package com.asayke.springaopexample;

import com.asayke.springaopexample.entity.Book;
import com.asayke.springaopexample.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringAopExampleApplication implements CommandLineRunner {
    private final BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringAopExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Book book1 = Book
                .builder()
                .author("Л.Н. Толстой")
                .title("Война и Мир")
                .build();

        Book book2 = Book
                .builder()
                .author("А.С. Пушкин")
                .title("Капитанская дочка")
                .build();

        bookRepository.save(book1);
        bookRepository.save(book2);
    }
}