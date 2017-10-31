package com.test.dao;

import com.test.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/20 0020.
 */
@Repository
public interface UserDao {
  User login(User u);
  void adda(User u);
  List<User> showUser();
  void del(ArrayList<Integer> data);
  void upd(Map<String,Object> map);
  List<User> findd(int start);
  List<User>search(Map<String,String>data);
  void editr(Map map);
  User findUser(String account);
}
