package com.bookverse.bookservice.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)
@Data
public class BookNotFoundException extends RuntimeException {
    private final String message;
}
