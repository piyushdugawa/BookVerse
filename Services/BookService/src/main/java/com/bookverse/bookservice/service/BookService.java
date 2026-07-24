package com.bookverse.bookservice.service;

import com.bookverse.bookservice.DTO.BookResponseDTO;
import com.bookverse.bookservice.mapper.BookMapper;
import com.bookverse.bookservice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public List<BookResponseDTO> findAllBooks(){
        return bookRepository
                .findAll()
                .stream()
                .map(bookMapper::toBookResponseDTO)
                .toList()
                ;
    }

    //TODO: Add service methods for Rest calls from controller

}
