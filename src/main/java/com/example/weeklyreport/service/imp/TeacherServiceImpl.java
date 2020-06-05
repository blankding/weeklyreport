package com.example.weeklyreport.service.imp;

import com.example.weeklyreport.dao.TeacherDao;
import com.example.weeklyreport.entity.Student;
import com.example.weeklyreport.entity.Teacher;
import com.example.weeklyreport.service.TeacherService;
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
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherDao teacherDao;

    /**老师查询所有*/
    @Override
    public Result findAll() {
        Result result = new Result();
        List<Teacher> teachers = teacherDao.findAll();
        result.setData(teachers);
        result.setStatus(0);
        result.setMsg("查询成功");
        return result;
    }

    /**新增老师*/
    @Override
    public Result addTeacher(int teacher_num, String teacher_name, String username, String email, String mobile) {
        Result result=new Result();
        Map<String,Object> map=new HashMap<String,Object>();
        map.clear();
        map.put("teacher_name", teacher_name);

        Teacher teacher=new Teacher();
        teacher.setTeacher_id(null);
        teacher.setTeacher_num(teacher_num);
        teacher.setTeacher_name(teacher_name);
        teacher.setUsername(username);
        teacher.setPassword(MSUtil.md5("111111"));
        teacher.setEmail(email);
        teacher.setMobile(mobile);
        teacher.setCreatime(null);
        teacher.setModifytime(null);
        teacherDao.save(teacher);
        result.setStatus(0);
        result.setMsg("新增老师成功");
        return result;
    }

    /**老师删除*/
    @Override
    public Result deleteTeacherById(int teacherId) {
        Result result = new Result();
        Teacher checkAdmin1 = teacherDao.findById(teacherId);
        if (checkAdmin1 == null) {
            result.setStatus(1);
            result.setMsg("不存在此老师");
            return result;
        }
        teacherDao.deleteById(teacherId);
        result.setStatus(0);
        result.setMsg("删除老师成功");
        return result;
    }

    /**老师更新*/
    @Override
    public Result updateTeacher(int teacher_id, int teacher_num, String teacher_name, String username, String password, String email, String mobile) {
        Result result=new Result();
        Teacher checkAdmin1=teacherDao.findById(teacher_id);
        if(checkAdmin1==null){
            result.setStatus(1);
            result.setMsg("不存在此老师");
            return result;
        }
        if(!"".equals(teacher_name)){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("teacher_name", teacher_name);
            Teacher checkAdmin2=teacherDao.dynamicFind(map);
            if(checkAdmin2!=null && !teacher_name.equals(checkAdmin1.getTeacher_name())){
                result.setStatus(1);
                result.setMsg("老师已经存在");
                return result;
            }
        }
        if(!"".equals(email)){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("email", email);
            Teacher checkAdmin2=teacherDao.dynamicFind(map);
            if(checkAdmin2!=null && !email.equals(checkAdmin1.getEmail())){
                result.setStatus(1);
                result.setMsg("邮箱已经存在");
                return result;
            }
        }
        Teacher teacher=new Teacher();
        teacher.setTeacher_id(teacher_id);
        teacher.setTeacher_num(teacher_num);
        teacher.setUsername(username);
        teacher.setTeacher_name(teacher_name);
        teacher.setMobile(mobile);
        teacher.setPassword(MSUtil.md5(password));
        teacher.setEmail(email);
        Timestamp now=new Timestamp(System.currentTimeMillis());
        teacher.setModifytime(now);
        teacherDao.dynamicUpdate(teacher);
        result.setStatus(0);
        result.setMsg("更新老师基本信息成功");
        return result;
    }

    /**修改密码*/
    @Override
    public Result updatePass(int teacher_num, String old_password, String new_password) {
        Result result=new Result();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("teacher_num", teacher_num);
        Teacher checkAdmin1=teacherDao.dynamicFind(map);
        if(checkAdmin1==null){
            result.setStatus(1);
            result.setMsg("不存在此老师");
            return result;
        }

        if(!MSUtil.md5(old_password).equals(checkAdmin1.getPassword())) {
            result.setStatus(1);
            result.setMsg("原密码错误");
            return result;
        }

        Teacher teacher=new Teacher();
        teacher.setTeacher_num(teacher_num);
        teacher.setPassword(MSUtil.md5(new_password));;
        Timestamp now=new Timestamp(System.currentTimeMillis());
        teacher.setModifytime(now);
        teacherDao.updatePWD(teacher);
        result.setStatus(0);
        result.setMsg("更新老师密码成功");
        result.setMsg(new_password);
        return result;
    }


    /**老师登录*/
    @Override
    public Result checkLogin(int teacher_num, String password) {
        Result result=new Result();
        if("".equals(teacher_num)){
            result.setStatus(1);
            result.setMsg("输入的教工号为空");
            return result;
        }
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("teacher_num", teacher_num);
        Teacher teacher=teacherDao.dynamicFind(map);
        return check(password,teacher);
    }

    private Result check(String password, Teacher teacher) {
        Result result=new Result();
        if(teacher==null){
            result.setStatus(1);
            result.setMsg("不存在此用户");
            return result;
        }
        if(!MSUtil.md5(password).equals(teacher.getPassword())){
            result.setStatus(1);
            result.setMsg("密码不正确");
            return result;
        }
        result.setStatus(0);
        result.setMsg("登录成功");
        result.setData(teacher);
        return result;
    }


}
