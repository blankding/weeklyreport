package com.example.weeklyreport.service.imp;


    import java.sql.Timestamp;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

        import javax.annotation.Resource;
        import com.example.weeklyreport.service.AdminService;
    import com.example.weeklyreport.util.MSUtil;
    import com.example.weeklyreport.util.Result;
        import org.springframework.stereotype.Service;
        import com.example.weeklyreport.dao.AdminDao;
        import com.example.weeklyreport.entity.Admin;
        import com.example.weeklyreport.util.Result;

/**
 * @author 丁鹏益
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;


    @Override
    public Result addAdmin(String mobile, String realName, int roleId) {
        return null;
    }
    /**登录*/
    @Override
    public Result checkLogin(String input, String password) {
        Result result=new Result();
        if("".equals(input)){
            result.setStatus(1);
            result.setMsg("输入的用户名为空");
            return result;
        }
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("username", input);
        Admin admin=adminDao.dynamicFind(map);
        return check(password,admin);
    }
    /**check方法*/
    private Result check(String password, Admin admin) {
        Result result=new Result();
        if(admin==null){
            result.setStatus(1);
            result.setMsg("不存在此用户");
            return result;
        }
        if(!MSUtil.md5(password).equals(admin.getPassword())){
            result.setStatus(1);
            result.setMsg("密码不正确");
            return result;
        }
        result.setStatus(0);
        result.setMsg("登录成功");
        result.setData(admin);
        return result;
    }
    /**更新管理员信息*/
    @Override
    public Result updateAdmin(int admin_id, String username, String password, String email, int sex,String mobile) {
        Result result=new Result();
        Admin checkAdmin1=adminDao.findById(admin_id);
        if(checkAdmin1==null){
            result.setStatus(1);
            result.setMsg("不存在此管理员");
            return result;
        }
        if(!"".equals(username)){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("username", username);
            Admin checkAdmin2=adminDao.dynamicFind(map);
            if(checkAdmin2!=null && !username.equals(checkAdmin1.getUsername())){
                result.setStatus(1);
                result.setMsg("用户名已经存在");
                return result;
            }
        }
        if(!"".equals(email)){
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("email", email);
            Admin checkAdmin2=adminDao.dynamicFind(map);
            if(checkAdmin2!=null && !email.equals(checkAdmin1.getEmail())){
                result.setStatus(1);
                result.setMsg("邮箱已经存在");
                return result;
            }
        }
        Admin admin=new Admin();
        admin.setAdmin_id(admin_id);
        admin.setUsername(username);
        admin.setMobile(mobile);
        admin.setPassword(MSUtil.md5(password));
        admin.setEmail(email);
        admin.setSex(sex);
        Timestamp now=new Timestamp(System.currentTimeMillis());
        admin.setModifytime(now);
        adminDao.dynamicUpdate(admin);
        result.setStatus(0);
        result.setMsg("更新管理员基本信息成功");
        return result;
    }

    @Override
    public Result updateMobileAndRealName(int adminId, String mobile, String realName) {
        return null;
    }

    @Override
    public Result loadAllAdmin() {
        return null;
    }
    /**加载管理员信息*/
    @Override
    public Result loadAdminById(int adminId) {
        Result result = new Result();
        Admin admin = adminDao.findById(adminId);
        if (admin == null) {
            result.setStatus(1);
            result.setMsg("不存在此管理员");
            return result;
        }
        result.setStatus(0);
        result.setMsg("加载管理员信息成功");
        result.setData(admin);
        return result;
    }
    /**根据id删除管理员*/
    @Override
    public Result deleteAdminById(int adminId) {
        Result result = new Result();
        Admin checkAdmin1 = adminDao.findById(adminId);
        if (checkAdmin1 == null) {
            result.setStatus(1);
            result.setMsg("不存在此管理员");
            return result;
        }
        adminDao.deleteById(adminId);
        result.setStatus(0);
        result.setMsg("删除管理员成功");
        return result;
    }
    /**查询所有管理员*/
    @Override
    public Result findAll() {
        Result result = new Result();

        List<Admin> admins = adminDao.findAll();

        result.setData(admins);
        result.setStatus(0);
        result.setMsg("查询成功");
        return result;
    }

    @Override
    public Result addAdmin2(String username, String email, String realName, String mobile, int roleId) {
        return null;
    }

    @Override
    public Result updateAdmin2(int adminId, String username, String realName, String email, String mobile, int sex) {
        return null;
    }
    /**管理员登录*/
    @Override
    public Result adminLogin(String username, String password) {
        Result result=new Result();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("username", username);
        Admin admin=adminDao.dynamicFind(map);
        return check(password,admin);
    }

    @Override
    public Result updatePass(int adminId, String old_password, String new_password) {
        return null;
    }

    @Override
    public Result dynamicFind2(Map map) {
        return null;
    }
    /**新增管理员*/
    @Override
    public Result addAdmin3(String username, String email, String mobile, int sex) {
        Result result=new Result();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("mobile", mobile);
        Admin checkAdmin=adminDao.dynamicFind(map);
        if(checkAdmin!=null){
            result.setStatus(1);
            result.setMsg("此电话号码已经存在");
            return result;
        }

        map.clear();
        map.put("username", username);
        checkAdmin=adminDao.dynamicFind(map);
        if(checkAdmin!=null){
            result.setStatus(1);
            result.setMsg(username+"已经存在");
            return result;
        }

        Admin admin=new Admin();
        admin.setAdmin_id(null);
        admin.setUsername(username);//默认username为空
        admin.setPassword(MSUtil.md5("111111"));//默认密码为六个1
        admin.setEmail(email);//默认email为空
        admin.setSex(sex);//默认为男
        admin.setMobile(mobile);
        admin.setCreatime(null);
        admin.setModifytime(null);
        adminDao.save(admin);
        result.setStatus(0);
        result.setMsg("新增管理员成功");
        return result;
    }


    @Override
    public Result findUnion2(Map map) {
        return null;
    }

}