package com.inkpenbookspublisher.controller;

import com.inkpenbookspublisher.model.request.CreateAuthorRequest;
import com.inkpenbookspublisher.model.response.InkPenBooksResponse;
import com.inkpenbookspublisher.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author")
@PreAuthorize("hasRole('AUTHOR')")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('author:read')")
    ResponseEntity<InkPenBooksResponse<?>>getAllAuthors(){
        return ResponseEntity.ok(InkPenBooksResponse.builder().isSuccess(true).response(authorService.getAllAuthors()).build());
    }

    @GetMapping("{authorId}")
    public ResponseEntity<InkPenBooksResponse<?>>getAuthorById(@PathVariable String authorId){
        return ResponseEntity.ok(InkPenBooksResponse.builder().isSuccess(true).response(authorService.getAuthorById(authorId)).build());
    }

    @DeleteMapping("{authorId}")
    public ResponseEntity<InkPenBooksResponse<?>>deleteAuthorById(@PathVariable String authorId){
        return ResponseEntity.ok(InkPenBooksResponse.builder().isSuccess(true).response(authorService.deleteAuthorById(authorId)).build());
    }
    @GetMapping("books/getAllBooksWithAuthors")
    public ResponseEntity<InkPenBooksResponse<?>>getAllBooksWithAuthor(){
        return ResponseEntity.ok(InkPenBooksResponse.builder().isSuccess(true).response(authorService.getAllBooksWithAuthor()).build());
    }

    @GetMapping("books/getBooksWithAuthor/{authorId}")
    public ResponseEntity<InkPenBooksResponse<?>>getBooksWithAuthor(@PathVariable String authorId){
        return ResponseEntity.ok(InkPenBooksResponse.builder().isSuccess(true).response(authorService.getBooksWithAuthor(authorId)).build());
    }
    @PostMapping("")
    ResponseEntity<InkPenBooksResponse<?>>saveAuthor(@RequestBody CreateAuthorRequest createAuthorRequest){
        return ResponseEntity.ok(InkPenBooksResponse.builder().isSuccess(true).response(authorService.saveAuthor(createAuthorRequest)).build());
    }
}
