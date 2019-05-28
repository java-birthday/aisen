package com.birthday.aisen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.birthday.aisen.mapper")
public class AisenApplication {

    public static void main(String[] args) {
        SpringApplication.run(AisenApplication.class, args);
    }

}
