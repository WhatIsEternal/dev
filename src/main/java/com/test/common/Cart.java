package com.test.common;

import com.test.entity.Book;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    //存放购买的书籍
    Map<String,Book> map = new HashMap<String, Book>();

    public void addBook(Book bk){
        //购物车中不存在此书
      if (!map.containsKey(bk.getId())){
            bk.setNum(bk.getNum()+1);
            map.put(bk.getId(),bk);
        }else{
            //购物车中存在该书
            Book book = map.get(bk.getId());
            book.setNum(book.getNum()+1);
        }
    }
    //查出购物车的书籍
    public Collection<Book> show(){
        return map.values();

    }
    //删除购物车书籍
    public void delete(String id){
        Book book=map.get(id);
        if(book.getNum()>1){
            book.setNum(book.getNum()-1);
        }else{
            map.remove(id);
        }
    }
    public float total(){
        float total=0;
        Collection<Book> bks = map.values();
        for( Book bs : bks){
            total= total+bs.getNum()*bs.getPrice();
        }
        return total;
    }
}
