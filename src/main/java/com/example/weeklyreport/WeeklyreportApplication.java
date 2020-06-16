package com.example.weeklyreport;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


/**
 * @author 丁鹏益
 */
@SpringBootApplication
@MapperScan("com.example.weeklyreport.dao")
public class WeeklyreportApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WeeklyreportApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WeeklyreportApplication.class);
    }
}
