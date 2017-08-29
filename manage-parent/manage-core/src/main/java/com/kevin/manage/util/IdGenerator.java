package com.kevin.manage.util;

import com.baomidou.mybatisplus.toolkit.IdWorker;

/**
 * 唯一ID生成器
 * @author ZGJ
 * @date 2017/8/29 19:08
*/
public class IdGenerator {

    public static String getId() {
        return String.valueOf(IdWorker.getId());
    }

    public static long getIdLong() {
        return IdWorker.getId();
    }
}
