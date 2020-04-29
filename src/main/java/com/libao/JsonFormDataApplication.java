package com.libao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.libao.domain.mapper")
@SpringBootApplication
public class JsonFormDataApplication{

    public static void main(String[] args) {
        SpringApplication.run(JsonFormDataApplication.class, args);
    }

}
