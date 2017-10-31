package com.test.controller;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.bcel.internal.generic.ReturnInstruction;
import com.test.common.Cart;
import com.test.dao.OrderDao;
import com.test.entity.*;
import com.test.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService os;
    @Resource
    private OrderDao od;



    @RequestMapping("toorder.do")
    public String toorder(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");
        os.createOrder(cart, user);
        return "redirect: /main/hisorder.jsp";
    }
    //后台订单展示
    @RequestMapping("showorder.do")
    @ResponseBody
    public List<Order>  showOrder(){
        List<Order> orders = os.showOrder();

        return orders;
    }
    @RequestMapping("editorder.do")
    @ResponseBody
    public String editOrder(String data){

        os.editOrder(data);

        return "1";
    }

    //前台展示历史订单
    @RequestMapping("hisorder.do")
    @ResponseBody
    public List<OrdersAll> hisOrder(HttpSession session){
        User user = (User) session.getAttribute("user");


        return  os.selectorderAll(user);
    }

    //退货流程
    @RequestMapping("returnorder.do")
    @ResponseBody
    public String returnOrder(String code, String createTime, String account){
        System.out.println("--------------------code" + code);
            os.returnOrder(code,createTime,account);
        return "1";
    }
    //后台退货单
    @RequestMapping("showorderreturn.do")
    @ResponseBody
    public List<OrderReturn> showOrderReturn(){

       return  od.returnOrder();
    }
    //后台修改退货状态
    @RequestMapping("editreturnorder.do")
    @ResponseBody
    @Transactional
    public String editReturnOrder(String ordercode){
        od.editReturnOrder(ordercode);
        od.editOrdersShip(ordercode);
        return "1";
    }
    //按月份显示订单
    @RequestMapping("orderspic.do")
    @ResponseBody
    public List<OrdersPic>  showOrdersPic(){

            List<OrdersPic> ordersPics = os.ordersPic();

            return ordersPics;

    }
    //按用户显示订单
    @RequestMapping("ordersusers.do")
    @ResponseBody
    public List<OrdersPic> showOrdersUsers(){
        return os.ordersUsers();
    }
}
