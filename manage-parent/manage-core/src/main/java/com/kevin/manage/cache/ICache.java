package com.kevin.manage.cache;

import java.util.List;

/**
 * 通用缓存接口
 * @author zhangguoji
 * @date 2017/8/29 16:29
 */
public interface ICache {
    /**
     * 放入缓存中
     * @param cacheName
     * @param key
     * @param value
     */
    void put(String cacheName, Object key, Object value);

    /**
     * 获取缓存中的值
     * @param cacheName
     * @param key
     * @param <T>
     * @return
     */
    <T> T get(String cacheName, Object key);

    /**
     * 获取所有缓存
     * @param cacheName
     * @return
     */
    @SuppressWarnings("rawtypes")
    List getKeys(String cacheName);

    /**
     * 从缓存中移除
     * @param cacheName
     * @param key
     */
    void remove(String cacheName, Object key);

    /**
     * 移除所有
     * @param cacheName
     */
    void removeAll(String cacheName);

    /**
     * 通过加载器加载
     * @param cacheName
     * @param key
     * @param iLoader
     * @param <T>
     * @return
     */
    <T> T get(String cacheName, Object key, ILoader iLoader);

    /**
     * 通过加载器的class文件加载
     * @param cacheName
     * @param key
     * @param iLoaderClass
     * @param <T>
     * @return
     */
    <T> T get(String cacheName, Object key, Class<? extends ILoader> iLoaderClass);
}
