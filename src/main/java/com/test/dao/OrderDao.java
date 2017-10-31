package com.test.dao;

import com.test.entity.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderDao {
    void createorder(Order order);
    void saveOrderItem(Map<String,Object> map);
    List<Order> showOrder();
    void editOrder (String id);
    List<OrdersAll> selectorderAll(User user);
    void editOrderShip(Map map);
    void addOrderReturn(Map map);
   List<OrderReturn> returnOrder();
   void editReturnOrder(String ordercode);
   void editOrdersShip(String ordercode);
    List<OrdersPic> ordersPic();
    List<OrdersPic> ordersUsers();
}
