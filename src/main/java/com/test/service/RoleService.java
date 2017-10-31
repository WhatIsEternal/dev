package com.test.service;

import com.test.dao.RoleDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class RoleService {
    @Resource
    private RoleDao rd;
    @Transactional
    public void doRolePerm(ArrayList<Integer> list){
        int rid = list.get(0);
        list.remove(0);
        Map map = new HashMap();
        map.put("rid",rid);
        map.put("permlist",list);
        rd.delRolePerm(map);
        rd.addRolePerm(map);



    }
}
