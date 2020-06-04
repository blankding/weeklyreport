package com.example.weeklyreport.service.imp;

import com.example.weeklyreport.dao.ReportDao;
import com.example.weeklyreport.dao.StudentDao;
import com.example.weeklyreport.entity.Report;
import com.example.weeklyreport.entity.Student;
import com.example.weeklyreport.entity.Teacher;
import com.example.weeklyreport.service.ReportService;
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
public class ReportServiceImpl implements ReportService {
    @Resource
    private ReportDao reportDao;
    @Resource
    private StudentDao studentDao;

    /**周报查询所有*/
    @Override
    public Result findAll() {
        Result result = new Result();

        List<Report> reports = reportDao.findAll();

        result.setData(reports);
        result.setStatus(0);
        result.setMsg("查询成功");
        return result;
    }

    /**新增周报*/
    @Override
    public Result addReport(int student_number, String class_id, int teacher_num, String study_aim, String reason, String problem, String next_aim) {
        Result result=new Result();
        Map<String,Object> map=new HashMap<String,Object>();
        map.clear();
        Report report=new Report();
        report.setReport_id(null);
        report.setStudent_number(student_number);
        report.setTeacher_number(teacher_num);
        report.setClass_id(class_id);
        report.setStudent_aim(study_aim);
        report.setReason(reason);
        report.setProblem(problem);
        report.setNext(next_aim);
        report.setCreatime(null);
        report.setModifytime(null);
        reportDao.save(report);
        result.setStatus(0);
        result.setMsg("新增周报成功");
        return result;
    }

    /**删除周报*/
    @Override
    public Result deleteReportById(int reportId) {
        Result result = new Result();
        Report checkAdmin1 = reportDao.findById(reportId);
        if (checkAdmin1 == null) {
            result.setStatus(1);
            result.setMsg("不存在此管理员");
            return result;
        }
        reportDao.deleteById(reportId);
        result.setStatus(0);
        result.setMsg("删除周报成功");
        return result;
    }

    /**更新周报*/
    @Override
    public Result updateReport(int report_id, String study_aim, String reason, String problem, String live, String next_aim) {
        Result result=new Result();
        Report checkAdmin1=reportDao.findById(report_id);
        if(checkAdmin1==null){
            result.setStatus(1);
            result.setMsg("不存在此周报");
            return result;
        }

        Report report=new Report();
        report.setReport_id(report_id);
        report.setStudent_aim(study_aim);
        report.setReason(reason);
        report.setProblem(problem);
        report.setNext(next_aim);
        report.setLive(live);
        Timestamp now=new Timestamp(System.currentTimeMillis());
        report.setModifytime(now);
        reportDao.dynamicUpdate(report);
        result.setStatus(0);
        result.setMsg("更新周报成功");
        return result;
    }

    /**
    * 根据学号查询
    * */
    @Override
    public Result findByStudentNumber(int student_number) {
        Result result=new Result();
//        Student checkAdmin1=studentDao.findBynumber(student_number);
//        if(checkAdmin1.equals(null)){
//            result.setStatus(1);
//            result.setMsg("不存在此学生");
//            return result;
//        }
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("student_number", student_number);
        result.setData(reportDao.findByStudentId(map));
        result.setStatus(0);
        result.setMsg("查询成功");
        return result;
    }

    /**根据班级号查询*/
    @Override
    public Result findByClassId(String class_id) {
        Result result=new Result();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("class_id", class_id);
        List checkAdmin1=reportDao.findByClassId(map);
        if(checkAdmin1.size()==0){
            result.setStatus(1);
            result.setMsg("不存在此班级");
            return result;
        }
        result.setData(reportDao.findByClassId(map));
        result.setStatus(0);
        result.setMsg("查询成功");
        return result;
    }

    /**根据学号回复*/
    @Override
    public Result answerByStudentNumber(int student_number,String answer) {
        Result result=new Result();
        Report checkAdmin1=reportDao.findByStudentNumber(student_number);
        if(checkAdmin1==null){
            result.setStatus(1);
            result.setMsg("不存在此学生");
            return result;
        }
        Report report=new Report();
        report.setStudent_number(student_number);
        report.setAnswer(answer);
        report.setCreatime(null);
        report.setModifytime(null);
        reportDao.saveAnswer(report);
        result.setStatus(0);
        result.setMsg("新增回答成功");
        return result;
    }

    /**根据班级计数(当前周)*/
    @Override
    public Result countByClassId(String class_id) {
        Result result=new Result();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("class_id", class_id);
        List checkAdmin1=reportDao.findByClassId(map);
        if(checkAdmin1.size()==0){
            result.setStatus(1);
            result.setMsg("不存在此班级");
            return result;
        }
        int classId = Integer.parseInt(class_id);
        result.setData(reportDao.countByClassId(classId));
        result.setStatus(0);
        result.setMsg("查询成功");
        return result;
    }

    /**根据学号查询（本周）*/
    @Override
    public Result findByStudentNum(int student_number) {
        Result result=new Result();
        List checkAdmin1=reportDao.findBystudentNum(student_number);
        if(checkAdmin1.size()==0){
            result.setStatus(1);
            result.setMsg("不存在此学生");
            return result;
        }
        result.setData(reportDao.findBystudentNum(student_number));
        result.setStatus(0);
        result.setMsg("查询成功");
        return result;
    }
}
