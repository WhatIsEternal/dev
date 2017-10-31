package com.test.service;

import com.test.common.Cart;
import com.test.dao.OrderDao;
import com.test.entity.Order;
import com.test.entity.OrdersAll;
import com.test.entity.OrdersPic;
import com.test.entity.User;
import com.test.utils.Primarykey;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    @Resource
    private OrderDao od;

    //创建订单
    @Transactional
    public void createOrder(Cart cart,User user) {
        String code = "" + System.currentTimeMillis();
        String id = Primarykey.createkey();
        Order order = new Order();
        //这是是订单状态-----------------------------------
        order.setStatus(0); //默认商品状态未确认
        order.setPay_status(1);//默认商品完成支付
        order.setShip_status(1);//默认商品已发货
        //上面是订单状态-----------------------------------
        String account = user.getAccount();
        order.setOwner(account);
        order.setId(id);
        order.setCode(code);
        order.setTotal(cart.total());
        //保存订单
        od.createorder(order);
        //保存订单详情
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ordersid", code);
        map.put("list", cart.show());
        od.saveOrderItem(map);
    }

    //后台展示订单
    public List<Order> showOrder(){
        List<Order> orders = od.showOrder();
        return orders;

    }
    //修改订单状态
    public void editOrder(String id){
        od.editOrder(id);
    }

    //展示历史订单
    public List<OrdersAll> selectorderAll(User user){

      return    od.selectorderAll(user);
    }

    //退货
    @Transactional
    public void returnOrder(String code, String createTime, String account){
        Map map = new HashMap();
        map.put("ordercode",code);
        map.put("own_account",account);
        map.put("createorder_time",createTime);
        map.put("return_status",1);
        map.put("status",0);
        map.put("code",code);

        //先修改订单的状态
        od.editOrderShip(map);
        //插入退货订单表
        od.addOrderReturn(map);

    }
    //按月份显示订单
    public List<OrdersPic> ordersPic(){
        List<OrdersPic> ordersPics = od.ordersPic();
        return ordersPics;
    }
//按用户显示订单
    public  List<OrdersPic> ordersUsers(){
        List<OrdersPic> ordersUsers = od.ordersUsers();
        return  ordersUsers;
    }

}
