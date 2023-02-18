package com.bookstore.dto;

import java.util.List;

public record AuthorDto(Long id, String name, int age, List<BookDto> books) {

    public void addBook(BookDto book) {
        books().add(book);
    }
}
