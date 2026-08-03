package com.bookverse.bookservice.controller;

import com.bookverse.bookservice.service.BookService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.crypto.SecretKey;
import java.util.Collections;
import java.util.Date;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class BookControllerTest {

    @Autowired
    private WebApplicationContext context;

    @MockitoBean
    private BookService bookService;

    private MockMvc mockMvc;

    private String validToken;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();

        String secret = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));

        validToken = Jwts.builder()
                .subject("testuser")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 60000))
                .signWith(key)
                .compact();
    }

    @Test
    void shouldDenyAccessWithoutBearerToken() throws Exception {
        mockMvc.perform(get("/api/v1/books"))
                .andExpect(status().isForbidden());
    }

    @Test
    void shouldAllowAccessWithValidBearerToken() throws Exception {
        when(bookService.findAllBooks()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/v1/books")
                        .header("Authorization", "Bearer " + validToken))
                .andExpect(status().isOk());
    }
}
