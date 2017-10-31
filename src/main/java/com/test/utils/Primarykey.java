package com.test.utils;

import java.util.UUID;

public class Primarykey {
    public static String createkey(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-","");
    }
}
