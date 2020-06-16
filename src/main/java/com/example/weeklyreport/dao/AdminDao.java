package com.example.weeklyreport.dao;

import com.example.weeklyreport.entity.Admin;

import java.util.List;
import java.util.Map;

/**
 * @author 丁鹏益
 */
public interface AdminDao {

    /**
     * 新建admin
     * @param admin
     * @return
     */
    public int save(Admin admin);

    /**
     * 查询所有
     * @return
     */
    public List<Admin> findAll();

    /**
     * 根据id删除
     * @param admin_id
     * @return
     */
    public int deleteById(int admin_id);

    /**
     * 根据id查询
     * @param admin_id
     * @return
     */
    public Admin findById(int admin_id);

    /**
     * 根据id更新管理员信息
     * @param admin
     * @return
     */
    public int dynamicUpdate(Admin admin);

    /**
     * 根据username,mobile,email查询
     * @param map
     * @return
     */
    public Admin dynamicFind(Map map);

    /**
     * 根据username,mobile,email查询
     * @return
     */
    public List<Admin> findUnion();

    /**
     * 根据username,mobile,email查询
     * @return
     */
    public List<Admin> dynamicFind2(Map map);
}
