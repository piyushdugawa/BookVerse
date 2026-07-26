package com.bookverse.bookservice.service;

import com.bookverse.bookservice.DTO.BookResponseDTO;
import com.bookverse.bookservice.exception.BookNotFoundException;
import com.bookverse.bookservice.mapper.BookMapper;
import com.bookverse.bookservice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.*;

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

    public  BookResponseDTO findBookById(int bookId){
        return bookMapper
                .toBookResponseDTO(bookRepository
                        .findById(bookId)
                        .orElseThrow(() -> new BookNotFoundException("Book with id: {" +  bookId + "} not found!")));
    }

    //TODO: Add service methods for Rest calls from controller

}
