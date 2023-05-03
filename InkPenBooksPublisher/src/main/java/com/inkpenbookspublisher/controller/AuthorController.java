package com.inkpenbookspublisher.controller;

import com.inkpenbookspublisher.model.request.CreateAuthorRequest;
import com.inkpenbookspublisher.model.response.InkPenBooksResponse;
import com.inkpenbookspublisher.service.AuthorService;
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
    ResponseEntity<InkPenBooksResponse<?>>getAllAuthors(){
        return ResponseEntity.ok(InkPenBooksResponse.builder().isSuccess(true).response(authorService.getAllAuthors()).build());
    }

    @GetMapping("books/{authorId}")
    public ResponseEntity<InkPenBooksResponse<?>>getAllBooksWithAuthor(@PathVariable String authorId){
        return ResponseEntity.ok(InkPenBooksResponse.builder().isSuccess(true).response(authorService.getAllBooksWithAuthor(authorId)).build());
    }
    @PostMapping("")
    ResponseEntity<InkPenBooksResponse<?>>saveAuthor(@RequestBody CreateAuthorRequest createAuthorRequest){
        return ResponseEntity.ok(InkPenBooksResponse.builder().isSuccess(true).response(authorService.saveAuthor(createAuthorRequest)).build());
    }
}
