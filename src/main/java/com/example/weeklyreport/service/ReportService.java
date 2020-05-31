package com.example.weeklyreport.service;

import com.example.weeklyreport.util.Result;

import java.util.Map;

public interface ReportService {
    //findall
    public Result findAll();
    //新增周报
    public Result addReport(int student_number,String class_id,int teacher_num,String study_aim,String reason,
                            String problem,String live,String next_aim);
    //根据id删除周报
    Result deleteReportById(int reportId);
    //更新周报
    Result updateReport(int report_id,String study_aim,String reason,String problem,
                         String live,String next_aim);
    /**连表查询根据studentnumber*/
    Result findByStudentNumber(int student_number);

    /**连表查询根据class_id*/
    Result findByClassId(String class_id);
}
