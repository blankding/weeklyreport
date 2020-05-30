package com.example.weeklyreport.controller;


import com.example.weeklyreport.service.StudentService;
import com.example.weeklyreport.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;

    //加载所有学生信息
    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public Result list() {
        Result result=studentService.findAll();
        return result;
    }

    //新增学生
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public Result add(int student_number,int class_id,String student_name,String email,String mobile,int sex){
        Result result=studentService.addStudent(student_number,class_id, student_name, email,mobile,sex);
        return result;
    }

    //删除学生
    @RequestMapping(value="/{StudentId}",method=RequestMethod.DELETE)
    @ResponseBody
    public Result deleteById(@PathVariable("StudentId") int StudentId){
        Result result=studentService.deleteStudentById(StudentId);
        return result;
    }
    //更新学生信息
    @RequestMapping(value="/updateById",method=RequestMethod.POST)
    @ResponseBody
    public Result updateById(int student_id,int student_number,int class_id,String student_name,String password,
                              String email,int sex,String mobile){
        Result result=studentService.updateStudent(student_id, student_number, class_id, student_name,password, email,sex,mobile);
        return result;
    }
    //学生登录
    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ResponseBody
    public Result checkLogin(String input,String password){
        Result result=studentService.checkLogin(input, password);
        return result;
    }
}
