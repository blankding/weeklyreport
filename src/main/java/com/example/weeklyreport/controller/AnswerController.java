package com.example.weeklyreport.controller;

import com.example.weeklyreport.service.ReportService;
import com.example.weeklyreport.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

    @Controller
    @RequestMapping("/teacher")
    public class AnswerController {
        @Resource
        private ReportService reportService;
        //打开所有html页面
        @RequestMapping("/teacher3")
        public String html(){
            return "teacher3";
        }

        /**添加回复*/
        @RequestMapping(value="/answer",method= RequestMethod.POST)
        @ResponseBody
        public Result Answer(String student_num, String answer){
            int student_number = Integer.parseInt(student_num);
            Result result=reportService.answerByStudentNumber(student_number, answer);
            return result;
        }

    }
