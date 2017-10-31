package com.test.dao;

import com.test.entity.Perm;
import com.test.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoleDao {
    List<Role> showRole();
    List<Role> selectrole();

    void delRolePerm(Map map);
    void addRolePerm(Map map);
}
