package com.example.weeklyreport.controller;


import com.example.weeklyreport.service.ReportService;
import com.example.weeklyreport.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/student")
public class WriteController {
    @Resource
    private ReportService reportService;
    /**
     * 打开所有页面
     */
    @RequestMapping("/write")
    public String html(){
        return "write";
    }

    /**
     * 新增周报
     * */
    @RequestMapping(value="/report_add",method=RequestMethod.POST)
    @ResponseBody
    public Result add(String student_num,String class_id,String teacher_number,String study_aim,String reason,
                      String problem,String next_aim){
        int student_number = Integer.parseInt(student_num);
        int teacher_num = Integer.parseInt(teacher_number);
        Result result=reportService.addReport(student_number,class_id,teacher_num, study_aim,reason,problem,next_aim);
        return result;
    }
}
