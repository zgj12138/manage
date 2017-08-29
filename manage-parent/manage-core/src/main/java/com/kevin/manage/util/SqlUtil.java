package com.kevin.manage.util;

import java.util.ArrayList;
import java.util.List;

/**
 * sql语句工具类
 * @author zhangguoji
 * @date 2017/8/29 18:33
 */
public class SqlUtil {
    /**
     * 根据集合的大小，输出相应个数的"?"
     * @param list
     * @return
     */
    public static String parse(List<?> list) {
        StringBuilder sb = new StringBuilder();
        if(list != null && list.size() > 0) {
            sb.append("?");
            for (int i = 1; i < list.size(); i++) {
                sb.append(",?");
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(2);
        System.out.println(parse(arrayList));
    }
}
