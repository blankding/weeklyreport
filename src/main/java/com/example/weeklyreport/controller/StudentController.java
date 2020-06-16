package com.example.weeklyreport.controller;


import com.example.weeklyreport.service.StudentService;
import com.example.weeklyreport.util.Result;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * @author 丁鹏益
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;
    //打开所有html页面
    @RequestMapping("/student")
    public String html(){
        return "student";
    }

    /**
     * 加载所有学生信息
     * */
    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public Result list() {
        Result result=studentService.findAll();
        return result;
    }

    /**
     * 新增学生
     * */
    @RequestMapping(value="/add",method=RequestMethod.POST)
    @ResponseBody
    public Result add(int student_number,String class_id,String student_name,String email,String mobile,int sex){
        Result result=studentService.addStudent(student_number,class_id, student_name, email,mobile,sex);
        return result;
    }

    /**
     * 删除学生
     * */
    @RequestMapping(value="/{StudentId}",method=RequestMethod.DELETE)
    @ResponseBody
    public Result deleteById(@PathVariable("StudentId") int StudentId){
        Result result=studentService.deleteStudentById(StudentId);
        return result;
    }

    /**
     * 更新学生信息
     * */
    @RequestMapping(value="/updateById",method=RequestMethod.POST)
    @ResponseBody
    public Result updateById(int student_id,int student_number,String class_id,String student_name,String password,
                              String email,int sex,String mobile){
        Result result=studentService.updateStudent(student_id, student_number, class_id, student_name,password, email,sex,mobile);
        return result;
    }

    /**
     * 学生登录
     * */
    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ResponseBody
    public Result StudentLogin(int student_number, String password, HttpServletRequest request ){
        Result result=studentService.checkLogin(student_number,password);
        if(result.getStatus() == 0) {
            request.getSession().setAttribute("adminInfo", result.getData());
        }

        return result;
    }

    /**
     * 修改密码
     * */
    @RequestMapping(value="/changePWD",method=RequestMethod.POST)
    @ResponseBody
    public Result Change(int student_number, String old_password, String new_password){
        Result result=studentService.updatePass(student_number, old_password, new_password);
        return result;
    }

    /**
     * 根据class_id查询信息
     * */
    @RequestMapping(value="/Unionlist",method= RequestMethod.POST)
    @ResponseBody
    public Result UnionList(String class_id) {
        Result result=studentService.findByClassId(class_id);
        return result;
    }
}
