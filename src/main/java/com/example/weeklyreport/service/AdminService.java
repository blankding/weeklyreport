package com.example.weeklyreport.service;

import com.example.weeklyreport.util.Result;

import java.util.Map;

public interface AdminService {
    //根据手机号添加
    public Result addAdmin(String mobile,String realName,int roleId);
    //登录验证
    public Result checkLogin(String input,String password);
    //完善基本信息
    public Result updateAdmin(int admin_id, String username, String password, String email, int sex,String mobile);
    //更新电话号和真实姓名
    public Result updateMobileAndRealName(int adminId,String mobile,String realName);
    //查询所有管理员（关联查询）
    public Result loadAllAdmin();
    //根据id查询
    public Result loadAdminById(int adminId);
    //删除管理员
    public Result deleteAdminById(int adminId);

    //findall
    public Result findAll();

    //根据手机号添加
    public Result addAdmin2(String username,String email,String realName,String mobile,int roleId);
    //完善基本信息
    public Result updateAdmin2(int adminId,String username,String realName,String email,String mobile,int sex);

    //管理员登录
    public Result adminLogin(String username,String password);

    public Result updatePass(int adminId,String old_password,String new_password);

    public Result dynamicFind2(Map map);

    //根据手机号添加
    public Result addAdmin3(String username,String email,String mobile,int sex);

    //完善基本信息

    public Result findUnion2(Map map);
}