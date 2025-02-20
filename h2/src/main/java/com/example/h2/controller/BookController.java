package com.example.h2.controller;

import com.example.h2.model.Book;
import com.example.h2.service.BookService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class BookController {
    private BookService service;
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return ResponseEntity.ok().body(service.createBook(book));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> getBook(@PathVariable Long id){
        return ResponseEntity.ok().body(service.readBook(id));
    }

    @PatchMapping
    public ResponseEntity<Optional<Book>> updateBook(@RequestBody Book book) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.ok().body(Optional.ofNullable(service.updateBook(book)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteBook(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }
}
