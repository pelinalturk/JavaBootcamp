package com.springboot.controller;

import com.springboot.model.request.CreateAuthorRequest;
import com.springboot.model.response.Response;
import com.springboot.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    public ResponseEntity<Response<?>> getAllAuthors(){
        return ResponseEntity.ok(Response.builder().isSuccess(true).response(authorService.getAllActiveAuthors()).build());
    }

    @PostMapping("")
    public ResponseEntity<Response<?>> createAuthor(@RequestBody CreateAuthorRequest createAuthorRequest){
        return ResponseEntity.ok(Response.builder().isSuccess(true).response(authorService.createAuthor(createAuthorRequest)).build());
    }
}
