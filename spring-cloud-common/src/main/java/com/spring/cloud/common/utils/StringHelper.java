package com.spring.cloud.common.utils;

/**
 * @author cdy
 * @create 2018/8/27
 */
public class StringHelper {
    public static String getObjectValue(Object obj){
        return obj==null?"":obj.toString();
    }
}
