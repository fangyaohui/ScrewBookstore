package com.fang.screwbookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ServletComponentScan
public class ScrewBookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScrewBookstoreApplication.class, args);
//        System.out.println("fagnyaohui 第二次修改");
    }

}
