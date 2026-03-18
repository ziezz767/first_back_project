package com.example.firstproject.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 일반 Controller 는 뷰페이지를 반환하지만 RestController 는 JSON 을 반환함! (RestAPI 용 컨트롤러)
public class FirstApiController {

    @GetMapping("/api/hello")
    public String hello() {
        return "hello world!";
    }
}
