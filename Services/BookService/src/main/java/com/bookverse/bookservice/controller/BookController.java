package com.bookverse.bookservice.controller;

import com.bookverse.bookservice.DTO.BookResponseDTO;
import com.bookverse.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> findAllBooks(){
        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @GetMapping("/{book_id}")
    public ResponseEntity<BookResponseDTO> findBookById(@PathVariable int book_id){
        return ResponseEntity.ok(bookService.findBookById(book_id));
    }

    //TODO: POST PUT DELETE(admin only) Mappings

}
