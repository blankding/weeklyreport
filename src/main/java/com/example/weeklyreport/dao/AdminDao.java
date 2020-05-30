package com.example.weeklyreport.dao;

import com.example.weeklyreport.entity.Admin;

import java.util.List;
import java.util.Map;

public interface AdminDao {
    public int save(Admin admin);
    public List<Admin> findAll();
    public int deleteById(int admin_id);
    public Admin findById(int admin_id);
    public int dynamicUpdate(Admin admin);
    public Admin dynamicFind(Map map);
    public List<Admin> findUnion();

    public List<Admin> dynamicFind2(Map map);

    public List<Admin> findUnion2(Map map);
}
