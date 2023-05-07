package com.inkpenbookspublisher.controller;

import com.inkpenbookspublisher.model.request.CreatePublisherRequest;
import com.inkpenbookspublisher.model.response.InkPenBooksResponse;
import com.inkpenbookspublisher.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("publisher")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping()
    ResponseEntity<InkPenBooksResponse<?>>getAllPublisher(){
        return ResponseEntity.ok(InkPenBooksResponse.builder().isSuccess(true).response(publisherService.getAllPublisher()).build());
    }

    @PostMapping("")
    ResponseEntity<InkPenBooksResponse<?>>savePublisher(@RequestBody CreatePublisherRequest createPublisherRequest){
        return ResponseEntity.ok(InkPenBooksResponse.builder().isSuccess(true).response(publisherService.savePublisher(createPublisherRequest)).build());
    }
}
