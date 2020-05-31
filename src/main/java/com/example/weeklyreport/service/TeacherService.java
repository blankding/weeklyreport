package com.example.weeklyreport.service;

import com.example.weeklyreport.util.Result;

public interface TeacherService {
    //findall
    public Result findAll();
    //新增老师
    public Result addTeacher(int teacher_num,String teacher_name,String username,String email,String mobile);
    //根据id删除老师
    Result deleteTeacherById(int teacherId);
    //更新老师的信息
    Result updateTeacher(int teacher_id,int teacher_num,String teacher_name,String username,String password,
                         String email,String mobile);
    //老师登录验证
    Result checkLogin(int teacher_num,String password);
}
