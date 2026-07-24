package com.bookverse.bookservice.DTO;

import java.util.Date;

public record BookResponseDTO(
        Integer id,
        String title,
        String author,
        String publisher,
        String isbn,
        String description,
        Double price,
        int stock,
        String category,
        Date publishedDate,
        double rating,
        long ratingCount
) {
}
