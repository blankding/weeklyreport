package com.example.weeklyreport.service;

import com.example.weeklyreport.util.Result;

public interface ReportService {
    //findall
    public Result findAll();
    //新增周报
    public Result addReport(int student_number,int class_id,int teacher_num,String study_aim,String reason,
                            String problem,String live,String next_aim);
    //根据id删除周报
    Result deleteReportById(int reportId);
    //更新周报
    Result updateReport(int report_id,String study_aim,String reason,String problem,
                         String live,String next_aim);
}
