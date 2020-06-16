package com.example.weeklyreport.service;

import com.example.weeklyreport.util.Result;

import java.util.Map;

/**
 * @author 丁鹏益 reportservice端
 */
public interface ReportService {
    /**查看所有
     * @return
     * */
    public Result findAll();

    /**
     * 新增周报
     * @param class_id
     * @param next_aim
     * @param problem
     * @param reason
     * @param student_number
     * @param study_aim
     * @param teacher_num
     * @return
     * */
    public Result addReport(int student_number,String class_id,int teacher_num,String study_aim,String reason,
                            String problem,String next_aim);
    /**
     * 根据id删除周报
     * @param reportId
     * @return
     * */
    Result deleteReportById(int reportId);

    /**
     * 更新周报
     * @param study_aim
     * @param reason
     * @param problem
     * @param next_aim
     * @param report_id
     * @return
     * */
    Result updateReport(int report_id,String study_aim,String reason,String problem,
                        String next_aim);

    /**
     * 连表查询根据student_number
     * @param student_number
     * @return
     * */
    Result findByStudentNumber(int student_number);

    /**
     * 连表查询根据class_id
     * @param class_id
     * @return
     * */
    Result findByClassId(String class_id);

    /**
     * 教师回复
     * @param student_number
     * @param answer
     * @return
     * */
    Result answerByStudentNumber(int student_number,String answer);

    /**
     * 根据班级号查询本周提交人数
     * @param class_id
     * @return
     * */
    Result countByClassId(String class_id);

    /**
     * 根据学号查询本周提交周报
     * @param student_number
     * @return
     * */
    Result findByStudentNum(int student_number);

    /**
     * 根据班级号查询上周提交周报
     * @param class_id
     * @return
     * */
    Result findByClassIdOld(String class_id);

    /**
     * 根据学号查询本月提交周报
     * @param student_number
     * @return
     *  */
    Result findByStudentNumMonth(int student_number);

    /**
     *  根据年月查报表
     * @param date
     * @param stuNo
     * @return
     */
    Result findByMonth(String date, String stuNo);

    /**
     *  根据月周查报表
     * @param date
     * @param classId
     * @return
     */
    Result findByWeek(String date, String classId);
}
