package com.example.weeklyreport.service.imp;

import com.example.weeklyreport.dao.ReportDao;
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

@Service
public class ReportServiceImpl implements ReportService {
    @Resource
    private ReportDao reportDao;

    //周报查询所有
    @Override
    public Result findAll() {
        Result result = new Result();

        List<Report> reports = reportDao.findAll();

        result.setData(reports);
        result.setStatus(0);
        result.setMsg("查询成功");
        return result;
    }

    //新增周报
    @Override
    public Result addReport(int student_number, int class_id, int teacher_num, String study_aim, String reason, String problem, String live, String next_aim) {
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
        report.setLive(live);
        report.setProblem(problem);
        report.setNext(next_aim);
        report.setCreatime(null);
        report.setModifytime(null);
        reportDao.save(report);
        result.setStatus(0);
        result.setMsg("新增周报成功");
        return result;
    }

    //删除周报
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

    //更新周报
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
}
