package com.inkpenbookspublisher.service;

import com.inkpenbookspublisher.model.Publisher;

import java.util.List;

public interface PublisherEntityService {
    Publisher save(Publisher publisher);
    List<Publisher>findAll();
}
