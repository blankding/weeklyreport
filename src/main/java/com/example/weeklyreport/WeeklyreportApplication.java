package com.example.weeklyreport;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.example.weeklyreport.dao")
@SpringBootApplication
public class WeeklyreportApplication {

    public static void main(String[] args) {

        SpringApplication.run(WeeklyreportApplication.class, args);
    }

}
