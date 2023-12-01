package com.asayke.springaopexample.service.implementation;

import com.asayke.springaopexample.dto.BookRequest;
import com.asayke.springaopexample.entity.Book;
import com.asayke.springaopexample.repository.BookRepository;
import com.asayke.springaopexample.service.interfaces.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final ModelMapper mapper;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findByTitle(String title) {
        return bookRepository.findByTitle(title).orElseThrow();
    }

    @Override
    public Book add(BookRequest bookRequest) {
        return bookRepository.save(convertToBook(bookRequest));
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    private Book convertToBook(BookRequest bookRequest) {
        return mapper.map(bookRequest, Book.class);
    }
}