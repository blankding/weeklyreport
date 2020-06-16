package com.example.weeklyreport.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.weeklyreport.service.ReportService;
import com.example.weeklyreport.util.Result;

/**
 * @author 丁鹏益
 */
@Controller
@RequestMapping("/report")
public class ReportController {
    @Resource
    private ReportService reportService;

    /**
     * 根据id加载周报信息
     * */
    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public Result list() {
        Result result=reportService.findAll();
        return result;
    }

    /**
     * 删除周报
     * */
    @RequestMapping(value="/DeleteReportId",method=RequestMethod.POST)
    @ResponseBody
    public Result deleteById( int ReportId){
        Result result=reportService.deleteReportById(ReportId);
        return result;
    }

    /**
     * 更新周报
     * */
    @RequestMapping(value="/updateById",method=RequestMethod.POST)
    @ResponseBody
    public Result updateById(int report_id,String study_aim,String reason,String problem
                           ,String next_aim){
        Result result=reportService.updateReport(report_id, study_aim, reason, problem, next_aim);
        return result;
    }

    /**
     * 根据class_id查询本周信息
     * */
    @RequestMapping(value="/classId",method= RequestMethod.GET)
    @ResponseBody
    public Result UnionList(String class_id) {
        Result result=reportService.findByClassId(class_id);
        return result;
    }

    /**
     * 根据class_id计数本周周报数量
     * */
    @RequestMapping(value="/count",method= RequestMethod.GET)
    @ResponseBody
    public Result countReport(String class_id) {
        Result result=reportService.countByClassId(class_id);
        return result;
    }

    /**
     * 根据student_number查看本周周报
     * */
    @RequestMapping(value="/weekreport",method= RequestMethod.POST)
    @ResponseBody
    public Result weekReport(int student_number) {
        Result result=reportService.findByStudentNum(student_number);
        return result;
    }

    /**
     * 根据class_id查询上周信息
     * */
    @RequestMapping(value="/classIdOld",method= RequestMethod.POST)
    @ResponseBody
    public Result OldWeek(String class_id) {
        Result result=reportService.findByClassIdOld(class_id);
        return result;
    }

    /**
     * 根据student_number查看本月周报
     * */
    @RequestMapping(value="/Student_numberMonth",method= RequestMethod.POST)
    @ResponseBody
    public Result MonthReport(int student_number) {
        Result result=reportService.findByStudentNumMonth(student_number);
        return result;
    }

    /**
     * 根据student_number按照年月来查看周报
     * */
    @RequestMapping(value="/findBymonth",method= RequestMethod.POST)
    @ResponseBody
    public Result findByMonth(String date, String stuNo) {
        Result result=reportService.findByMonth(date,stuNo);
        return result;
    }

    /**
     * 根据student_number按照本月各周次来查看周报
     * */
    @RequestMapping(value="/findByweek",method= RequestMethod.POST)
    @ResponseBody
    public Result findByWeek(String date, String classId) {
        Result result=reportService.findByWeek(date,classId);
        return result;
    }
}
