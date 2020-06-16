package com.example.weeklyreport.controller;


import com.example.weeklyreport.service.AdminService;
import com.example.weeklyreport.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 丁鹏益
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;


    /**
     * 打开所有html页面
     *
     * @return
     */
    @RequestMapping("/login")
    public String html() {
        return "login";
    }


    /**
     * 根据adminId删除
     */
    @RequestMapping(value = "/{adminId}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result deleteById(@PathVariable("adminId") int adminId) {
        Result result = adminService.deleteAdminById(adminId);
        return result;
    }

    /**
     * 根据username登陆
     */
    @CrossOrigin
    @RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
    @ResponseBody
    public Result adminLogin(String username, String password, HttpServletRequest request) {
        Result result = adminService.adminLogin(username, password);
        if (result.getStatus() == 0) {
            request.getSession().setAttribute("adminInfo", result.getData());
        }

        return result;

    }

    /**
     * 新增管理员
     */
    @RequestMapping(value = "/add3", method = RequestMethod.POST)
    @ResponseBody
    public Result add3(String username, String email, String mobile, int sex) {
        Result result = adminService.addAdmin3(username, email, mobile, sex);
        return result;
    }

    /**
     * 更新管理员信息
     */
    @RequestMapping(value = "/updateById3", method = RequestMethod.POST)
    @ResponseBody
    public Result updateById3(int admin_id, String username, String password, String email, int sex, String mobile) {
        Result result = adminService.updateAdmin(admin_id, username, password, email, sex, mobile);
        return result;
    }

}
