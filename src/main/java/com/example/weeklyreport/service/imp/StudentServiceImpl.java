package com.example.weeklyreport.service.imp;

import com.example.weeklyreport.dao.StudentDao;
import com.example.weeklyreport.entity.Admin;
import com.example.weeklyreport.entity.Student;
import com.example.weeklyreport.entity.Teacher;
import com.example.weeklyreport.service.StudentService;
import com.example.weeklyreport.util.MSUtil;
import com.example.weeklyreport.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 丁鹏益
 */

@Service
public class StudentServiceImpl implements StudentService {

@Resource
private StudentDao studentDao;

    /**学生查询所有*/
    @Override
    public Result findAll() {
        Result result = new Result();

        List<Student> students = studentDao.findAll();

        result.setData(students);
        result.setStatus(0);
        result.setMsg("查询成功");
        return result;
    }

    @Override
    public Result findByNumber(int student_number) {
        Result result=new Result();
        Student checkAdmin1=studentDao.findBynumber(student_number);
        if (checkAdmin1==null){
            result.setStatus(1);
            result.setMsg("不存在此学生");
            return result;
        }
        result.setStatus(0);
        result.setMsg("查询学生成功");
        return result;
    }

    /**新增学生*/
    @Override
    public Result addStudent(int student_number, String class_id, String student_name, String email, String mobile, int sex) {
        Result result=new Result();
        Map<String,Object> map=new HashMap<String,Object>();
        map.clear();
        map.put("student_name", student_name);

        Student student=new Student();
        student.setStudent_id(null);
        student.setStudent_number(student_number);
        student.setClass_id(class_id);
        student.setStudent_name(student_name);
        student.setPassword(MSUtil.md5("111111"));
        student.setEmail(email);
        student.setSex(sex);
        student.setMobile(mobile);
        student.setCreatime(null);
        student.setModifytime(null);
        studentDao.save(student);
        result.setStatus(0);
        result.setMsg("新增学生成功");
        return result;
    }

    /**学生删除*/
    @Override
    public Result deleteStudentById(int studentId) {
        Result result = new Result();
        Student checkAdmin1 = studentDao.findById(studentId);
        if (checkAdmin1 == null) {
            result.setStatus(1);
            result.setMsg("不存在此学生");
            return result;
        }
        studentDao.deleteById(studentId);
        result.setStatus(0);
        result.setMsg("删除学生成功");
        return result;
    }

    /**学生更新*/
    @Override
    public Result updateStudent(int student_id, int student_number, String class_id, String student_name, String password, String email, int sex, String mobile) {
        Result result=new Result();
        Student checkAdmin1=studentDao.findById(student_id);
        if(checkAdmin1==null){
            result.setStatus(1);
            result.setMsg("不存在此学生");
            return result;
        }

        Student student=new Student();
        student.setStudent_id(student_id);
        student.setStudent_number(student_number);
        student.setClass_id(class_id);
        student.setStudent_name(student_name);
        student.setMobile(mobile);
        student.setPassword(MSUtil.md5(password));
        student.setEmail(email);
        student.setSex(sex);
        Timestamp now=new Timestamp(System.currentTimeMillis());
        student.setModifytime(now);
        studentDao.dynamicUpdate(student);
        result.setStatus(0);
        result.setMsg("更新学生基本信息成功");
        return result;
    }

    /**修改密码*/
    @Override
    public Result updatePass(int student_number, String old_password, String new_password) {
        Result result=new Result();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("student_number", student_number);
        Student checkAdmin1=studentDao.dynamicFind(map);
        if(checkAdmin1==null){
            result.setStatus(1);
            result.setMsg("不存在此学生");
            return result;
        }

        if(!MSUtil.md5(old_password).equals(checkAdmin1.getPassword())) {
            result.setStatus(1);
            result.setMsg("原密码错误");
            return result;
        }

        Student student=new Student();
        student.setStudent_number(student_number);
        student.setPassword(MSUtil.md5(new_password));
        Timestamp now=new Timestamp(System.currentTimeMillis());
        student.setModifytime(now);
        studentDao.dynamicUpdate(student);
        result.setStatus(0);
        result.setMsg("更新学生密码成功");
        return result;
    }

    /**学生登录*/
    @Override
    public Result checkLogin(int student_number, String password) {
        Result result=new Result();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("student_number", student_number);
        Student student=studentDao.dynamicFind(map);
        return check(password,student);
        }

    /**登录*/
    private Result check(String password, Student student) {
            Result result=new Result();
            if(student==null){
                result.setStatus(1);
                result.setMsg("不存在此用户");
                return result;
            }
            if(!MSUtil.md5(password).equals(student.getPassword())){
                result.setStatus(1);
                result.setMsg("密码不正确");
                return result;
            }
            result.setStatus(0);
            result.setMsg("登录成功");
            result.setData(student);
            return result;
        }

    /**根据class_id连表查询*/
    @Override
    public Result findByClassId(String class_id) {
        Result result=new Result();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("class_id", class_id);
        result.setData(studentDao.findByClassId(map));
        result.setStatus(0);
        result.setMsg("查询成功");
        return result;
    }
}

