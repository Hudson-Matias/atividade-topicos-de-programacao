package com.example.h2.service;

import com.example.h2.model.Book;
import com.example.h2.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public Optional<Book> readBook(Long id){
        return bookRepository.findById(id);
    }

    public Book updateBook(Book book) throws ChangeSetPersister.NotFoundException {
        return bookRepository.findById(book.getId()).map(book1 -> {
                book1.setAutor(book.getAutor());
                book1.setName(book.getName());
                return bookRepository.save(book1);
        }).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}
