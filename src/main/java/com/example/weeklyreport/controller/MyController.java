package com.example.weeklyreport.controller;

import com.example.weeklyreport.service.ReportService;
import com.example.weeklyreport.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/student")
public class MyController {
    @Resource
    private ReportService reportService;

    //打开所有html页面
    @RequestMapping("/my")
    public String html() {
        return "my";
    }

    /**根据student_number查询信息*/
    @RequestMapping(value="/studentNumber",method= RequestMethod.POST)
    @ResponseBody
    public Result UnionList(int student_number) {
        Result result=reportService.findByStudentNumber(student_number);
        return result;
    }

}