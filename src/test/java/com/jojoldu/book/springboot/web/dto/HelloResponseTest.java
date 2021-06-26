package com.jojoldu.book.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseTest {

    @Test
    public void 롬복_테스트() {
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponse helloResponse = new HelloResponse(name, amount);

        // then
        assertThat(helloResponse.getName()).isEqualTo(name);
        assertThat(helloResponse.getAmount()).isEqualTo(amount);
    }
}