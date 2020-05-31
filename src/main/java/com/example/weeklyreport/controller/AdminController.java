package com.example.weeklyreport.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.example.weeklyreport.entity.Admin;
import com.example.weeklyreport.service.AdminService;
import com.example.weeklyreport.util.Result;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;


    @RequestMapping(value="/add2",method=RequestMethod.POST)
    @ResponseBody
    public Result add2(String username,String email,String realName,String mobile,int roleId){

        Result result=adminService.addAdmin2(username,email,realName,mobile,  roleId);
        return result;
    }

    @RequestMapping(method=RequestMethod.POST)
    @ResponseBody
    public Result add(String mobile,String realName,int roleId){
        Result result=adminService.addAdmin(mobile, realName, roleId);
        return result;
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ResponseBody
    public Result checkLogin(String input,String password){
        Result result=adminService.checkLogin(input, password);
        return result;
    }

//    @RequestMapping(value="/{adminId}",method=RequestMethod.PUT)
//    @ResponseBody
//    public Result updateById(@PathVariable("adminId") int adminId,
//                             String username,String password,String email,int sex){
//        Result result=adminService.updateAdmin(adminId, username, password, email, sex);
//        return result;
//    }

    @RequestMapping(value="/mobile_realName/{adminId}",method=RequestMethod.PUT)
    @ResponseBody
    public Result updateMobileAndRealName(@PathVariable("adminId") int adminId,
                                          String mobile,String realName){
        Result result=adminService.updateMobileAndRealName(adminId, mobile, realName);
        return result;
    }

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public Result loadAll(){
        Result result=adminService.loadAllAdmin();
        return result;
    }

    @RequestMapping(value="/{adminId}",method=RequestMethod.GET)
    @ResponseBody
    public Result loadById(@PathVariable("adminId") int adminId){
        Result result=adminService.loadAdminById(adminId);
        return result;
    }

    @RequestMapping(value="/{adminId}",method=RequestMethod.DELETE)
    @ResponseBody
    public Result deleteById(@PathVariable("adminId") int adminId){
        Result result=adminService.deleteAdminById(adminId);
        return result;
    }

    //根据id加载地址信息
    @RequestMapping(value="/list",method=RequestMethod.GET)
    @ResponseBody
    public ModelAndView list() {
        Result result=adminService.findAll();

        ModelAndView mv=new ModelAndView();
        mv.setViewName("admin_list");
        mv.addObject("msg", "管理员列表");
        mv.addObject("admins", result.getData());

        return mv;
    }

    //根据id加载地址信息
    @RequestMapping(value="/updateview",method=RequestMethod.GET)
    @ResponseBody
    public ModelAndView updateview(int adminId){
        Result result=adminService.loadAdminById(adminId);

        ModelAndView mv=new ModelAndView();
        mv.setViewName("admin_edit");
        mv.addObject("admin", result.getData());

        return mv;
    }

    @RequestMapping(value="/updateById2",method=RequestMethod.POST)
    @ResponseBody
    public Result updateById2(int adminId,
                              String username,String realName,String email,String mobile,int sex){
        Result result=adminService.updateAdmin2(adminId, username, realName, email,mobile, sex);
        return result;
    }

    @RequestMapping(value="/deleteById2",method=RequestMethod.GET)
    @ResponseBody
    public Result deleteById2(int adminId){
        Result result=adminService.deleteAdminById(adminId);
        return result;
    }

    @RequestMapping(value="/adminLogin",method=RequestMethod.POST)
    @ResponseBody
    public Result adminLogin(String username, String password,HttpServletRequest request ){
        Result result=adminService.adminLogin(username, password);
        if(result.getStatus() == 0)
        {
            request.getSession().setAttribute("adminInfo", result.getData());
        }

        return result;
    }

    //根据id加载地址信息
    @RequestMapping(value="/mainView",method=RequestMethod.GET)
    @ResponseBody
    public ModelAndView mainView(HttpServletRequest request){

        ModelAndView mv=new ModelAndView();
        mv.setViewName("mainView");
        mv.addObject("admin", request.getSession().getAttribute("adminInfo"));

        return mv;
    }

    @RequestMapping(value="/updatePass",method=RequestMethod.POST)
    @ResponseBody
    public Result updatePass(int adminId,String old_password,String new_password){
        Result result=adminService.updatePass(adminId, old_password, new_password);
        return result;
    }

    @RequestMapping(value="/loginOut",method=RequestMethod.GET)
    @ResponseBody
    public ModelAndView loginOut(HttpServletRequest request){
        request.getSession().removeAttribute("adminInfo");

        ModelAndView mv=new ModelAndView();
        mv.setViewName("login");

        return mv;
    }

    @RequestMapping(value="/listview",method=RequestMethod.GET)
    @ResponseBody
    public ModelAndView listview(ModelAndView modelAndView) {
        modelAndView.setViewName("admin/adminList");
        return modelAndView;
    }


    @RequestMapping(value="/add3",method=RequestMethod.POST)
    @ResponseBody
    public Result add3(String username,String email,String mobile,int sex){
        Result result=adminService.addAdmin3(username,email, mobile, sex);
        return result;
    }

    @RequestMapping(value="/updateById3",method=RequestMethod.POST)
    @ResponseBody
    public Result updateById3(int admin_id, String username, String password, String email, int sex,String mobile){
        Result result=adminService.updateAdmin(admin_id, username, password, email,sex, mobile);
        return result;
    }

}
