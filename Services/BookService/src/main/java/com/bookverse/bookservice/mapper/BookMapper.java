package com.bookverse.bookservice.mapper;

import com.bookverse.bookservice.DTO.BookResponseDTO;
import com.bookverse.bookservice.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookMapper {
    public BookResponseDTO toBookResponseDTO(Book book) {
        return new BookResponseDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublisher(),
                book.getIsbn(),
                book.getDescription(),
                book.getPrice(),
                book.getStock(),
                book.getCategory(),
                book.getPublishedDate(),
                book.getRating(),
                book.getRatingCount()
        );
    }
}
