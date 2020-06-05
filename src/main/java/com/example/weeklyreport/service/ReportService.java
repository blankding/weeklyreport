package com.example.weeklyreport.service;

import com.example.weeklyreport.util.Result;

import java.util.Map;

/**
 * @author 丁鹏益 reportservice端
 */
public interface ReportService {
    /**查看所有*/
    public Result findAll();

    /**新增周报*/
    public Result addReport(int student_number,String class_id,int teacher_num,String study_aim,String reason,
                            String problem,String next_aim);
    /**根据id删除周报*/
    Result deleteReportById(int reportId);

    /**更新周报*/
    Result updateReport(int report_id,String study_aim,String reason,String problem,
                         String live,String next_aim);

    /**连表查询根据student_number*/
    Result findByStudentNumber(int student_number);

    /**连表查询根据class_id*/
    Result findByClassId(String class_id);

    /**教师回复*/
    Result answerByStudentNumber(int student_number,String answer);

    /**根据班级号查询本周提交人数*/
    Result countByClassId(String class_id);

    /**根据学号查询本周提交周报*/
    Result findByStudentNum(int student_number);

    /**根据班级号查询上周提交周报*/
    Result findByClassIdOld(String class_id);

    /**根据学号查询本月提交周报*/
    Result findByStudentNumMonth(int student_number);
}
