package com.example.weeklyreport.service;

import com.example.weeklyreport.util.Result;

import java.util.Map;

/**
 * @author 丁鹏益 管理员service端
 */
public interface AdminService {
    /**根据手机号添加*/
    public Result addAdmin(String mobile,String realName,int roleId);

    /**登录验证*/
    public Result checkLogin(String input,String password);

    /**完善基本信息*/
    public Result updateAdmin(int admin_id, String username, String password, String email, int sex,String mobile);

    /**根据id查询*/
    public Result loadAdminById(int adminId);

    /**删除管理员*/
    public Result deleteAdminById(int adminId);

    /**findall*/
    public Result findAll();

    /**管理员登录*/
    public Result adminLogin(String username,String password);

    /**管理员新增*/
    public Result addAdmin3(String username,String email,String mobile,int sex);

}