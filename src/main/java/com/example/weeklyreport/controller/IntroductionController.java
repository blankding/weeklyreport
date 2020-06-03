package com.example.weeklyreport.controller;

import com.example.weeklyreport.service.ReportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author 丁鹏益
 */
@Controller
@RequestMapping("/student")
public class IntroductionController {
    @Resource
    private ReportService reportService;

    @RequestMapping("/introduction")
    public String html() {
        return "introduction";
    }
}