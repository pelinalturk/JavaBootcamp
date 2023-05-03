package com.inkpenbookspublisher.service.impl;

import com.inkpenbookspublisher.model.Publisher;
import com.inkpenbookspublisher.model.dto.PublisherDto;
import static com.inkpenbookspublisher.model.mapper.PublisherMapper.PUBLISHER_MAPPER;
import com.inkpenbookspublisher.model.request.CreatePublisherRequest;
import com.inkpenbookspublisher.service.PublisherEntityService;
import com.inkpenbookspublisher.service.PublisherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherEntityService publisherEntityService;

    public PublisherServiceImpl(PublisherEntityService publisherEntityService) {
        this.publisherEntityService = publisherEntityService;
    }

    @Override
    public PublisherDto savePublisher(CreatePublisherRequest createPublisherRequest) {
        Publisher publisher = PUBLISHER_MAPPER.createPublisher(createPublisherRequest);
        publisherEntityService.save(publisher);
        return PUBLISHER_MAPPER.convertToPublisherDto(publisher);
    }

    @Override
    public List<PublisherDto> getAllPublisher() {
        return publisherEntityService.findAll().stream().map(PUBLISHER_MAPPER::convertToPublisherDto).collect(Collectors.toList());
    }
}
