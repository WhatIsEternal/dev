package com.test.controller;

import com.test.dao.RoleDao;
import com.test.entity.Perm;
import com.test.entity.Role;
import com.test.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RoleController {
    @Resource
    private RoleDao rd;
    @Resource
    private RoleService rs;
    @RequestMapping("showRole.do")
    @ResponseBody
    public List<Role> show(){


        return rd.showRole();
    }
    @RequestMapping("selectRole.do")
    @ResponseBody
    public List<Role> selectRole(){

        return rd.selectrole();
    }

    @RequestMapping("change.do")
    @ResponseBody
    public String change(@RequestBody ArrayList<Integer> list){
        System.out.println("list 值" + list);

        rs.doRolePerm(list);
        return "1";
    }
}
