package com.example.weeklyreport.dao;


import com.example.weeklyreport.entity.Teacher;

import java.util.List;
import java.util.Map;

/**
 * @author 丁鹏益
 */
public interface TeacherDao {

    /**
     * 新建teacher
     * @param teacher
     * @return
     */
    public int save(Teacher teacher);

    /**
     * 查询所有教师信息
     * @return
     */
    public List<Teacher> findAll();

    /**
     * 根据教师id删除
     * @param teacher_id
     * @return
     */
    public int deleteById(int teacher_id);

    /**
     * 根据教师id查询
     * @param teacher_id
     * @return
     */
    public Teacher findById(int teacher_id);

    /**
     * 更新教师信息
     * @param teacher
     * @return
     */
    public int dynamicUpdate(Teacher teacher);

    /**
     * 修改教师密码
     * @param teacher
     * @return
     */
    int updatePWD(Teacher teacher);

    /**
     * 根据教工号查询教师信息
     * @param map
     * @return
     */
    public Teacher dynamicFind(Map map);

}
