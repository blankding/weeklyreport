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
import java.util.Map;

/**
 * @author 丁鹏益
 */
@Controller
@RequestMapping("/report")
public class ReportController {
    @Resource
    private ReportService reportService;

    /**根据id加载地址信息*/
    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public Result list() {
        Result result=reportService.findAll();
        return result;
    }

//    /**新增周报*/
//    @RequestMapping(value="/add",method=RequestMethod.POST)
//    @ResponseBody
//    public Result add(int student_number,String class_id,int teacher_num,String study_aim,String reason,
//                      String problem,String live,String next_aim){
//        Result result=reportService.addReport(student_number,class_id, teacher_num, study_aim,reason,problem,live,next_aim);
//        return result;
//    }

    /**删除周报*/
    @RequestMapping(value="/DeleteReportId",method=RequestMethod.POST)
    @ResponseBody
    public Result deleteById( int ReportId){
        Result result=reportService.deleteReportById(ReportId);
        return result;
    }

    /**更新周报*/
    @RequestMapping(value="/updateById",method=RequestMethod.POST)
    @ResponseBody
    public Result updateById(int report_id,String study_aim,String reason,String problem,
                             String live,String next_aim){
        Result result=reportService.updateReport(report_id, study_aim, reason, problem,live, next_aim);
        return result;
    }

    /**根据class_id查询本周信息*/
    @RequestMapping(value="/classId",method= RequestMethod.POST)
    @ResponseBody
    public Result UnionList(String class_id) {
        Result result=reportService.findByClassId(class_id);
        return result;
    }

    /**根据class_id计数本周周报数量*/
    @RequestMapping(value="/count",method= RequestMethod.POST)
    @ResponseBody
    public Result countReport(String class_id) {
        Result result=reportService.countByClassId(class_id);
        return result;
    }

    /**根据student_number查看本周周报*/
    @RequestMapping(value="/weekreport",method= RequestMethod.POST)
    @ResponseBody
    public Result weekReport(int student_number) {
        Result result=reportService.findByStudentNum(student_number);
        return result;
    }

    /**根据class_id查询上周信息*/
    @RequestMapping(value="/classIdOld",method= RequestMethod.POST)
    @ResponseBody
    public Result OldWeek(String class_id) {
        Result result=reportService.findByClassIdOld(class_id);
        return result;
    }

    /**根据student_number查看本月周报*/
    @RequestMapping(value="/Student_numberMonth",method= RequestMethod.POST)
    @ResponseBody
    public Result MonthReport(int student_number) {
        Result result=reportService.findByStudentNumMonth(student_number);
        return result;
    }
}
