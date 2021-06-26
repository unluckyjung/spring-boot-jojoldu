package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public HelloResponse hello(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponse(name, amount);
    }

    @GetMapping("/hello2")
    public HelloResponse hello2(final String name, final int amount) {
        return new HelloResponse(name, amount);
    }
}
