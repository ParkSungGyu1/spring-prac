package com.spring.springapiprac.model;

import com.spring.springapiprac.dto.NoticeDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoticeTest {
    @Test
    @DisplayName("정상 케이스")
    void createProduct_Normal() {
        // given

        String username = "박성규";
        String password = "test";
        String title = "테스트 제목입니다.";
        String description = "테스트 내용입니다.";


        NoticeDto requestDto = new NoticeDto(
                username,
                password,
                title,
                description

        );

// when
        Notice product = new Notice(requestDto);

// then

        assertEquals(password, product.getPassword());
        assertEquals(title, product.getTitle());
        assertEquals(description, product.getDescription());
        assertEquals(username, product.getUsername());
    }
}