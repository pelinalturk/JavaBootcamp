package com.inkpenbookspublisher.service;

import com.inkpenbookspublisher.model.dto.PublisherDto;
import com.inkpenbookspublisher.model.request.CreatePublisherRequest;

import java.util.List;

public interface PublisherService {
    PublisherDto savePublisher(CreatePublisherRequest createPublisherRequest);
    List<PublisherDto>getAllPublisher();
}
