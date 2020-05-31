package com.example.weeklyreport.controller;

import com.example.weeklyreport.entity.Teacher;
import com.example.weeklyreport.service.StudentService;
import com.example.weeklyreport.service.TeacherService;
import com.example.weeklyreport.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Resource
    private TeacherService teacherService;

    //根据id加载地址信息
    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public Result list() {
        Result result=teacherService.findAll();
        return result;
    }
    //新增老师
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public Result add(int teacher_num,String teacher_name,String username,String email,String mobile){
        Result result=teacherService.addTeacher(teacher_num,teacher_name, username, email,mobile);
        return result;
    }

    //删除老师
    @RequestMapping(value="/{TeacherId}",method=RequestMethod.DELETE)
    @ResponseBody
    public Result deleteById(@PathVariable("TeacherId") int TeacherId){
        Result result=teacherService.deleteTeacherById(TeacherId);
        return result;
    }

    //更新老师信息
    @RequestMapping(value="/updateById",method=RequestMethod.POST)
    @ResponseBody
    public Result updateById(int teacher_id,int teacher_num,String teacher_name,String username,String password,
                             String email,String mobile){
        Result result=teacherService.updateTeacher(teacher_id, teacher_num, teacher_name, username,password, email,mobile);
        return result;
    }

    //老师登录
    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ResponseBody
    public Result checkLogin(int teacher_num, String password, HttpServletRequest request){
        Result result=teacherService.checkLogin(teacher_num,password);
        if(result.getStatus() == 0)
        {
            request.getSession().setAttribute("adminInfo", result.getData());
        }
        return result;
    }
}
