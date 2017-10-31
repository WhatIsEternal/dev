package com.test.controller;

import com.test.common.Cart;
import com.test.dao.BookDao;
import com.test.entity.Book;
import com.test.utils.MD5Utils;
import com.test.utils.Primarykey;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.context.transaction.TestTransaction.start;

@Controller
public class BookController {
    @Resource
    private BookDao bd;

    @RequestMapping("addbook.do")
    @ResponseBody
    public String doBook(@RequestParam("ff") final MultipartFile ff, @RequestParam Map<String, String> map,
                         HttpServletRequest req) {
        String filename = ff.getOriginalFilename();
        final String path = req.getServletContext().getRealPath("/img/" + System.currentTimeMillis() + filename);
        System.out.println("path" + path);
        try {
            new Thread(){
                @Override
                public void run(){
                    try {
                        ff.transferTo(new File(path));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();


            String title = map.get("title").toString();
            //封装为book对象
            Book bk = new Book(Primarykey.createkey(), map.get("title"), map.get("typeid"), map.get("bookcontent"), filename, 99,map.get("numbers"));
            bd.addBook(bk);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "1";
    }

    @RequestMapping("findallbook.do")
    @ResponseBody
    public List<Book> findAllBook() {
        return bd.findAllBook();
    }
    @RequestMapping("tobooklist.do")
    public String toBookList(HttpSession session){
        List<Book> bs = bd.findAllBook();
        session.setAttribute("bs",bs);
        return "booklist";

    }
    @RequestMapping("buy.do")
    public String buy(String id,HttpSession session){
        Book bk = bd.findBookById(id);
        System.out.println("book"+bk);
        //从session中获取购物车对象
        Cart cart = (Cart) session.getAttribute("cart");
        //第一次购买
        if(cart == null){
            cart = new Cart();
            session.setAttribute("cart",cart);
        }
        cart.addBook(bk);
        return "redirect:main/cart.jsp";

    }
    //删除
    @RequestMapping("delete.do")
    @ResponseBody
    public String delete(String id,HttpSession session){
        Cart cart = (Cart) session.getAttribute("cart");
        cart.delete(id);
        return "1";
    }
    @RequestMapping("ups.do")
    public int add(Book bok){
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("numbers",bok.getNumbers());
        map.put("id",bok.getId());
        bd.upds(map);
        return 0;
    }

}
