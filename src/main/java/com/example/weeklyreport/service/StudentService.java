package com.example.weeklyreport.service;

import com.example.weeklyreport.util.Result;

import java.util.Map;

/**
 * @author 丁鹏益 学生service端
 */
public interface StudentService {

    /**
     * 查询所有学生信息
     * @return
     * */
    public Result findAll();

    /**
     * 查询所有学生信息
     * @param student_number
     * @return
     * */
    public Result findByNumber(int student_number);

    /**
     * 新增学生
     * @param class_id
     * @param mobile
     * @param sex
     * @param email
     * @param teacher_num
     * @param uname
     * @return
     * */
    public Result addStudent(int teacher_num,String class_id,String uname,String email,String mobile,int sex);

    /**
     * 根据id删除学生
     * @param studentId
     * @return
     * */
    Result deleteStudentById(int studentId);

    /**
     * 更新学生的信息
     * @param email
     * @param sex
     * @param mobile
     * @param class_id
     * @param student_number
     * @param password
     * @param student_id
     * @param student_name
     * @return
     * */
    Result updateStudent(int student_id,int student_number,String class_id,String student_name,String password,
                         String email,int sex,String mobile);

    /**
     * 学生登录验证
     * @param password
     * @param student_number
     * @return
     * */
    Result checkLogin(int student_number,String password);

    /**
     * 连表查询根据classid
     * @param class_id
     * @return
     * */
    Result findByClassId(String class_id);

    /**
     * 学生更改密码
     * @param student_number
     * @param new_password
     * @param old_password
     * @return
     * */
    Result updatePass(int student_number, String old_password, String new_password);
}
