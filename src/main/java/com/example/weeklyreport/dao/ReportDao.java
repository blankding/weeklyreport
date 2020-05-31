package com.example.weeklyreport.dao;

import com.example.weeklyreport.entity.Report;
import com.example.weeklyreport.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * @author 丁鹏益
 */
public interface ReportDao {
    public int save(Report report);
    public List<Report> findAll();
    public int deleteById(int report_id);
    public Report findById(int report_id);
    public int dynamicUpdate(Report report);
    public Report dynamicFind(Map map);
    public List<Report> findUnion();
    public List<Report> dynamicFind2(Map map);
    public List<Report> findUnion2(Map map);
    List<Report> findByStudentId(Map map);
    List<Report> findByClassId(Map map);
}
