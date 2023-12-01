package com.asayke.springaopexample.service.interfaces;

import com.asayke.springaopexample.dto.BookRequest;
import com.asayke.springaopexample.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findByTitle(String title);

    Book add(BookRequest bookRequest);

    void deleteById(Long id);
}