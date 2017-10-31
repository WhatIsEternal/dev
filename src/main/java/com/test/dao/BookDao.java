package com.test.dao;

import com.test.entity.Book;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BookDao {
    //allEntries = true 即开启服务
    //重建缓存,即执行完这个方法之后就重建value={"findAllBook"}的缓存
    @CacheEvict(value={"findAllBook","upds"},allEntries = true)
    void addBook(Book bk);
    @Cacheable("findAllBook") //括号里是键名
    List<Book> findAllBook(); //把该方法返回的数据缓存到redis
    Book findBookById(String id);
    @Cacheable("upds")
    void upds(Map<String,Object> map);
}
