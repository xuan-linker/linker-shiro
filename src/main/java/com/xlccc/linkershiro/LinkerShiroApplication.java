package com.xlccc.linkershiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.xlccc.linkshiro.dao")
@SpringBootApplication
public class LinkerShiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinkerShiroApplication.class, args);
    }

}
