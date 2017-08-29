package com.kevin.manage.db;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.kevin.manage.util.SpringContextHolder;

/**
 * <p>
 * 便捷数据库操作类
 * 本类的使用情景：
 * <p>
 * 1.单纯想创建现有的Mapper
 * <p>例如:
 * Db.getMapper(UserLoginMapper.class).selectById("14779707158513204");<br>
 * <p>
 * @author zhangguoji
 * @date 2017/8/29 18:23
 */
@SuppressWarnings("all")
public class Db<T> {
    /**
     * Db类包装的Mapper接口
     */
    private Class<T> clazz;
    /**
     * Mapper的父接口
     */
    private BaseMapper<?> baseMapper;

    private Db(Class<T> clazz) {
        this.clazz = clazz;
        this.baseMapper = (BaseMapper<?>) SpringContextHolder.getBean(clazz);
    }
}
