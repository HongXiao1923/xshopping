package com.javaclimb.xshopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.javaclimb.xshopping.mapper")
public class XshoppingApplication {

    public static void main(String[] args) {
        SpringApplication.run(XshoppingApplication.class, args);
    }

}
