package com.example.weeklyreport.dao;


import com.example.weeklyreport.entity.Teacher;

import java.util.List;
import java.util.Map;

/**
 * @author 丁鹏益
 */
public interface TeacherDao {

    public int save(Teacher teacher);
    public List<Teacher> findAll();
    public int deleteById(int teacher_id);
    public Teacher findById(int teacher_id);
    public int dynamicUpdate(Teacher teacher);
    int updatePWD(Teacher teacher);
    public Teacher dynamicFind(Map map);
    public List<Teacher> findUnion();

    public List<Teacher> dynamicFind2(Map map);

    public List<Teacher> findUnion2(Map map);
}
