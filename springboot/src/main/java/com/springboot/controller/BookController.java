package com.springboot.controller;

import com.springboot.model.request.CreateBookRequest;
import com.springboot.model.request.UpdateBookRequest;
import com.springboot.model.response.Response;
import com.springboot.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("")
    public ResponseEntity<Response<?>> createBook(@RequestBody CreateBookRequest createBookRequest){
        try {
            return ResponseEntity.ok(Response.builder().isSuccess(true).response(bookService.createBook(createBookRequest)).build());
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Response<?>> deleteBook(@PathVariable("id") String id){
        bookService.deleteBook(id);
        return ResponseEntity.ok(Response.builder().isSuccess(true).build());
    }

    @PutMapping("{id}/author/change/{name}")
    public ResponseEntity<Response<?>> updateNameOfAuthorByBook(@PathVariable("id") String id, @PathVariable("name") String name){
        return ResponseEntity.ok(Response.builder().isSuccess(true).response(bookService.updateNameOfAuthorByBook(id, name)).build());
    }

    @GetMapping()
    public ResponseEntity<Response<?>> getAllBooks(){
        return ResponseEntity.ok(Response.builder().isSuccess(true).response(bookService.getAllBooks()).build());
    }

    @GetMapping("{authorID}")
    public ResponseEntity<Response<?>> getBooksByAuthorId(@PathVariable("authorID") String authorId){
        return ResponseEntity.ok(Response.builder().isSuccess(true).response(bookService.getBooksByAuthorId(authorId)).build());
    }

    @PatchMapping("/updateNameAndReleaseDateOfBook")
    public ResponseEntity<Response<?>> updateNameAndReleaseDateOfBook(@RequestBody UpdateBookRequest updateBookRequest){
        return ResponseEntity.ok(Response.builder().isSuccess(true).response(bookService.updateNameAndReleaseDateOfBook(updateBookRequest)).build());
    }
}