package com.example.weeklyreport.dao;

import com.example.weeklyreport.entity.Admin;
import com.example.weeklyreport.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * @author 丁鹏益
 */
public interface StudentDao {

    /**
     * 新建student
     * @param student
     * @return
     */
    public int save(Student student);

    /**
     * 查询所有student
     * @return
     */
    public List<Student> findAll();

    /**
     * 根据student_id删除
     * @param student_id
     * @return
     */
    public int deleteById(int student_id);

    /**
     * 根据student_id查询
     * @param student_id
     * @return
     */
    public Student findById(int student_id);

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    public int dynamicUpdate(Student student);

    /**
     * 根据学号和姓名查详细信息
     * @param map
     * @return
     */
    public Student dynamicFind(Map map);

    /**
     * 根据班级号查学生
     * @param map
     * @return
     */
    List<Student> findByClassId(Map map);

    /**
     * 根据学号查学生
     * @param student_number
     * @return
     */
    Student findBynumber(int student_number);
}
