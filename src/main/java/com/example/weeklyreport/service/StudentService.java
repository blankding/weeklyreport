package com.example.weeklyreport.service;

import com.example.weeklyreport.util.Result;

public interface StudentService {
    //findall
    public Result findAll();
    //新增老师
    public Result addStudent(int teacher_num,int class_id,String uname,String email,String mobile,int sex);
    //根据id删除学生
    Result deleteStudentById(int studentId);
    //更新学生的信息
    Result updateStudent(int student_id,int student_number,int class_id,String student_name,String password,
                         String email,int sex,String mobile);
    //学生登录验证
    Result checkLogin(String input,String password);
}
