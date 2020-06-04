package com.example.weeklyreport.service;

import com.example.weeklyreport.util.Result;

import java.util.Map;

/**
 * @author 丁鹏益 学生service端
 */
public interface StudentService {
    /**查询所有学生信息*/
    public Result findAll();
    /**查询所有学生信息*/
    public Result findByNumber(int student_number);
    /**新增学生*/
    public Result addStudent(int teacher_num,String class_id,String uname,String email,String mobile,int sex);
    /**根据id删除学生*/
    Result deleteStudentById(int studentId);
    /**更新学生的信息*/
    Result updateStudent(int student_id,int student_number,String class_id,String student_name,String password,
                         String email,int sex,String mobile);
    /**学生登录验证*/
    Result checkLogin(int student_number,String password);
    /**连表查询根据classid*/
    Result findByClassId(String class_id);
    /**老师更改密码*/
    Result updatePass(int student_number, String old_password, String new_password);
}
