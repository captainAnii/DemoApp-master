package com.geekster.DemoApp;

import org.springframework.stereotype.Component;

@Component // Marking the class as a Spring bean using @Component
public class HelloService {

    public String getMessage() {
        return "Hello, Spring Boot!";
    }
}