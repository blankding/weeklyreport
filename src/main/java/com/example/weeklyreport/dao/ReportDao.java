package com.example.weeklyreport.dao;

import com.example.weeklyreport.entity.Report;

import java.util.List;
import java.util.Map;

/**
 * @author 丁鹏益
 */
public interface ReportDao {

    /**
     * 新建report
     * @param report
     * @return
     */
    public int save(Report report);

    /**
     * 根据查出所有report
     * @return
     */
    public List<Report> findAll();

    /**
     * 根据reportId删除
     * @param report_id
     * @return
     */
    public int deleteById(int report_id);

    /**
     * 根据reportId查
     * @param report_id
     * @return
     */
    public Report findById(int report_id);

    /**
     * 更新周报内容
     * @param report
     * @return
     */
    public int dynamicUpdate(Report report);

    /**
     * 根据学号查
     * @param map
     * @return
     */
    List<Report> findByStudentId(Map map);

    /**
     * 根据班级号查看
     * @param map
     * @return
     */
    List <Report> findByClassId(Map<String, Object> map);

    /**
     * 根据学号写回答
     * @param report
     * @return
     */
    public int saveAnswer(Report report);

    /**
     * 根据学号查询周报
     * @param student_number
     * @return
     */
    Report findByStudentNumber(int student_number);

    /**
     * 根据班级id计数当前周报数
     * @param class_id
     * @return
     */
    int countByClassId(int class_id);
    /**
     *    按学号查询当前周
     * @param student_number
     * @return
     */
    List<Report> findBystudentNum(int student_number);
    /**
     *    按班级号查询上周
     * @param map
     * @return
     */
    List <Report> findOldWeek (Map<String, Object> map);
    /**
     *    按学号查询当前月
     * @param student_number
     * @return
     */
    List<Report> findBystudentNumMonth (int student_number);

    /**
     *    按年月查询
     * @param map key="realMonth"
     * @return
     */
    List<Report> findByMonth(Map<String,Object> map);

    /**
     *    按本月各周查询
     * @param map key="realWeek"
     * @return
     */
    List<Report> findByWeek(Map<String,Object> map);
}
