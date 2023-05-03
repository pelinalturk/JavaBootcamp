package com.inkpenbookspublisher.service.impl;

import com.inkpenbookspublisher.model.Publisher;
import com.inkpenbookspublisher.repository.PublisherRepository;
import com.inkpenbookspublisher.service.PublisherEntityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherEntityServiceImpl implements PublisherEntityService {

    private final PublisherRepository publisherRepository;

    public PublisherEntityServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }
}
