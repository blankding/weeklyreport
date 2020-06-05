package com.example.weeklyreport.controller;

import com.example.weeklyreport.service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author 丁鹏益
 */
@Controller
@RequestMapping("/teacher")
public class CountController {
    @Resource
    private ReportService reportService;

    //打开所有html页面
    @RequestMapping("/teacher2")
    public String html() {
        return "teacher2";
    }



}