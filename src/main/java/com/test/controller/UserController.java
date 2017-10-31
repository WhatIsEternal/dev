package com.test.controller;

import com.test.dao.UserDao;
import com.test.entity.User;
import com.test.entity.UserRole;
import com.test.utils.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
@Controller
public class UserController {
    @Resource
    private UserDao ud;
    @RequestMapping("login.do")
    public String login(String account, String pwd, HttpSession session) {
        try {
            Subject user = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(account,MD5Utils.md5(pwd));
            user.login(token);
            User user1 = ud.findUser(account);
            session.setAttribute("user",user1);
            return "index";
        } catch (Exception e) {
            e.printStackTrace();
            return "login";
        }
    }
    @RequestMapping("adda.do")
    @ResponseBody
    public int adda(User u){
        //调用mybatis添加用户
        if(u.getUid()==0){
            String s = MD5Utils.md5(u.getPwd());
            u.setPwd(s);
            ud.adda(u);
            return 0;
        }else{
            Map<String,Object> map=new HashMap<String, Object>();
            String s1 = MD5Utils.md5(u.getPwd());
            map.put("pwd",s1);
            map.put("uid",u.getUid());
            ud.upd(map);
            return 0;
        }

    }
    @RequestMapping("find.do")
    @ResponseBody
    public List<User> find(int page){
        int start=(page-1)*2;
        return ud.findd(start);
    }
    @RequestMapping("del.do")
    @ResponseBody
    public String del(@RequestBody ArrayList<Integer> data){
        ud.del(data);
        return "1";
    }

    //搜索
    @RequestMapping("search.do")
    @ResponseBody
    public List<User> search(String type,String key){
        Map<String, String>data=new HashMap<String,String>();
        data.put("type",type);
        data.put("key","%"+key+"%");
        return ud.search(data);
    }

    @RequiresRoles("管理员")
    @RequestMapping("toRole.do")
    public String toRole() {

        return "toRole";
    }

    @RequestMapping("toIndex.do")
    public String toLogin() {

        return "login";
    }

    @RequestMapping("toNoqx.do")
    public String toNoqx() {

        return "noqx";
    }

    @RequestMapping("showUser.do")
    @ResponseBody
    public List<UserRole> showUser(){
        ArrayList<User> list = (ArrayList<User>) ud.showUser();
        List<UserRole> li = fun(list);
        return li;
    }
    @RequestMapping("editUserRole.do")
    @ResponseBody
    public String edit(int uid, String account, int rid){
        Map map = new HashMap();
        map.put("rid",rid);
        map.put("uid",uid);
        ud.editr(map);
        return  "1";
    }












    public static List<UserRole> fun(ArrayList<User> list){
        List<UserRole> li = new ArrayList<UserRole>();
        for (int i = 0; i <list.size() ; i++) {
            UserRole ur = new UserRole();
            ur.setUid(list.get(i).getUid());
            ur.setAccount(list.get(i).getAccount());
            ur.setRole_name(list.get(i).getRole().getRole_name());
            ur.setRid(list.get(i).getRole().getRid());
            li.add(ur);
        }
        return li;
    }

}
