package com.example.weeklyreport.service;

import com.example.weeklyreport.util.Result;
/**
 * @author 丁鹏益 教师service端
 */
public interface TeacherService {

    /**
     * 查出所有
     * @return
     * */
    public Result findAll();

    /**
     * 新增老师
     * @param mobile
     * @param email
     * @param teacher_num
     * @param username
     * @param teacher_name
     * @return
     * */
    public Result addTeacher(int teacher_num,String teacher_name,String username,String email,String mobile);

    /**
     * 根据id删除老师
     * @param teacherId
     * @return
     * */
    Result deleteTeacherById(int teacherId);

    /**
     * 更新老师的信息
     * @param teacher_name
     * @param username
     * @param teacher_num
     * @param email
     * @param mobile
     * @param password
     * @param teacher_id
     * @return
     * */
    Result updateTeacher(int teacher_id,int teacher_num,String teacher_name,String username,String password,
                         String email,String mobile);

    /**
     * 老师登录验证
     * @param password
     * @param teacher_num
     * @return
     * */
    Result checkLogin(int teacher_num,String password);

    /**
     * 老师更改密码
     * @param teacher_num
     * @param old_password
     * @param new_password
     * @return
     * */
    Result updatePass(int teacher_num, String old_password, String new_password);
}
