package com.geekster.DemoApp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Marking the class as a configuration class using @Configuration
public class MyConfig {

    @Bean // Defining a bean using @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}