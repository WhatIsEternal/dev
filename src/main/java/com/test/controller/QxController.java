package com.test.controller;

import com.test.dao.QxDao;
import com.test.entity.Qx;
import com.test.entity.Rows;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;

import java.util.List;

@Controller
public class QxController {
    @Resource
    private QxDao qd;


    @RequestMapping("showQx.do")
    @ResponseBody
    public Rows showQx(){

        List<Qx> list =   qd.showQx();
        Rows rows = new Rows();
        rows.setRows(list);
        System.out.println(list);
        return rows ;
    }


}
