package com.inkpenbookspublisher.controller;

import com.inkpenbookspublisher.model.request.CreateBookRequest;
import com.inkpenbookspublisher.model.response.InkPenBooksResponse;
import com.inkpenbookspublisher.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public ResponseEntity<InkPenBooksResponse<?>>getAllBooks(){
        return ResponseEntity.ok(InkPenBooksResponse.builder().isSuccess(true).response(bookService.getAllBooks()).build());
    }

    @PostMapping("")
    public ResponseEntity<InkPenBooksResponse<?>>saveBook(@RequestBody CreateBookRequest createBookRequest){
        return ResponseEntity.ok(InkPenBooksResponse.builder().isSuccess(true).response(bookService.saveBook(createBookRequest)).build());
    }

    @GetMapping("{bookId}")
    public ResponseEntity<InkPenBooksResponse<?>>getBookById(@PathVariable String bookId){
        return ResponseEntity.ok(InkPenBooksResponse.builder().isSuccess(true).response(bookService.getBookById(bookId)).build());
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<InkPenBooksResponse<?>>getBooksByAuthorId(@PathVariable String authorId){
        return ResponseEntity.ok(InkPenBooksResponse.builder().isSuccess(true).response(bookService.getBooksByAuthorId(authorId)).build());
    }

    @DeleteMapping("{bookId}")
    public ResponseEntity<InkPenBooksResponse<?>>deleteBookById(@PathVariable String bookId){
        bookService.deleteBookById(bookId);
        return ResponseEntity.ok(InkPenBooksResponse.builder().isSuccess(true).build());
    }
}
