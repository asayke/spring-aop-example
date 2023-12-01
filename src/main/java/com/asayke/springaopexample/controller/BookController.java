package com.asayke.springaopexample.controller;

import com.asayke.springaopexample.dto.BookRequest;
import com.asayke.springaopexample.entity.Book;
import com.asayke.springaopexample.service.interfaces.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{title}")
    public ResponseEntity<Book> findByTitle(@PathVariable("title") String title) {
        return ResponseEntity.ok(bookService.findByTitle(title));
    }

    @PostMapping
    public ResponseEntity<Book> add(BookRequest bookRequest) {
       return ResponseEntity.ok(bookService.add(bookRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}