package com.test.utils;

import org.springframework.stereotype.Repository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    public static String md5(String data) {
        StringBuilder sd = new StringBuilder();
        try {
            //获取实例
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //更新数据
            md5.update(data.getBytes());
            //加密
            byte[] des = md5.digest();
            for (int i = 0; i <des.length ; i++) {
                int y = des[i]&0xff;
                //干预 - 加盐
//                y = y-1+98;
                if(y < 16){
                    sd.append(0);
                }
                //转化为16进制
                sd.append(Integer.toHexString(y));
            }
            System.out.println(sd.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sd.toString();
    }

    public static void main(String[] args) {
        String cc = md5("ee");

    }
}
