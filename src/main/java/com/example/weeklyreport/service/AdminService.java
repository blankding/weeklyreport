package com.example.weeklyreport.service;

import com.example.weeklyreport.util.Result;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author 丁鹏益 管理员service端
 */
public interface AdminService {

    /**
     * 根据手机号添加
     * @param mobile
     * @param realName
     * @param roleId
     * @return
     * */
    public Result addAdmin(String mobile,String realName,int roleId);

    /**
     * 登录验证
     * @param  input
     * @param password
     * @return
     * */
    public Result checkLogin( String input,  String password);

    /**
     * 完善基本信息
     * @param admin_id
     * @param mobile
     * @param email
     * @param password
     * @param sex
     * @param username
     * @return
     * */
    public Result updateAdmin(int admin_id, String username, String password, String email, int sex,String mobile);

    /**
     * 根据id查询
     * @param adminId
     * @return
     * */
    public Result loadAdminById(int adminId);

    /**
     * 删除管理员
     * @param adminId
     * @return
     * */
    public Result deleteAdminById(int adminId);

    /**
     * findall
     * @param
     * @return
     * */
    public Result findAll();

    /**
     * 管理员登录
     * @param username
     * @param password
     * @return
     * */
    public Result adminLogin(String username,String password);

    /**
     * 管理员新增
     * @param username
     * @param email
     * @param sex
     * @param mobile
     * @return
     * */
    public Result addAdmin3(String username,String email,String mobile,int sex);

}