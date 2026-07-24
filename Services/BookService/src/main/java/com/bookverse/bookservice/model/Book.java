package com.bookverse.bookservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    private Integer id;

    private String title;
    private String author;
    private String publisher;
    private String isbn;
    private String description;
    private Double price;
    private int stock;
    private String category;
    private Date publishedDate;
    private double rating;
    private long ratingCount;
}
