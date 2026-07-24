package com.bookverse.bookservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Validated
@Entity
public class Book {

    @Id
    @GeneratedValue
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
