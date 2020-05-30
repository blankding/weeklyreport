package com.example.weeklyreport.controller;

import com.example.weeklyreport.service.ReportService;
import com.example.weeklyreport.service.StudentService;
import com.example.weeklyreport.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/report")
public class ReportController {
    @Resource
    private ReportService reportService;

    //根据id加载地址信息
    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public Result list() {
        Result result=reportService.findAll();
        return result;
    }

    //新增周报
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public Result add(int student_number,int class_id,int teacher_num,String study_aim,String reason,
                      String problem,String live,String next_aim){
        Result result=reportService.addReport(student_number,class_id, teacher_num, study_aim,reason,problem,live,next_aim);
        return result;
    }

    //删除周报
    @RequestMapping(value="/{ReportId}",method=RequestMethod.DELETE)
    @ResponseBody
    public Result deleteById(@PathVariable("ReportId") int ReportId){
        Result result=reportService.deleteReportById(ReportId);
        return result;
    }
    //更新周报
    @RequestMapping(value="/updateById",method=RequestMethod.POST)
    @ResponseBody
    public Result updateById(int report_id,String study_aim,String reason,String problem,
                             String live,String next_aim){
        Result result=reportService.updateReport(report_id, study_aim, reason, problem,live, next_aim);
        return result;
    }
}
