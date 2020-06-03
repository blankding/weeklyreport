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
public class IntroductionTController {
    @Resource
    private ReportService reportService;

    @RequestMapping("/introduction2")
    public String html() {
        return "introduction2";
    }
}