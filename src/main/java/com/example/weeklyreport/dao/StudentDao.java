package com.example.weeklyreport.dao;

import com.example.weeklyreport.entity.Admin;
import com.example.weeklyreport.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * @author 丁鹏益
 */
public interface StudentDao {
    public int save(Student student);
    public List<Student> findAll();
    public int deleteById(int student_id);
    public Student findById(int student_id);
    public int dynamicUpdate(Student student);
    public Student dynamicFind(Map map);
    public List<Student> findUnion();

    public List<Student> dynamicFind2(Map map);

    public List<Student> findUnion2(Map map);
    List<Student> findByClassId(Map map);
}
