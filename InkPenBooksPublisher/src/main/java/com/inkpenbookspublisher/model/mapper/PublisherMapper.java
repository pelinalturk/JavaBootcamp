package com.inkpenbookspublisher.model.mapper;

import com.inkpenbookspublisher.model.Publisher;
import com.inkpenbookspublisher.model.dto.PublisherDto;
import com.inkpenbookspublisher.model.request.CreatePublisherRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PublisherMapper {
    public static PublisherMapper PUBLISHER_MAPPER = Mappers.getMapper(PublisherMapper.class);

    PublisherDto convertToPublisherDto(Publisher publisher);
    Publisher createPublisher(CreatePublisherRequest createPublisherRequest);
}
