package com.kevin.manage.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Ehcache缓存工厂，单例模式
 * @author zhangguoji
 * @date 2017/8/29 16:40
 */
public class EhcacheFactory extends BaseCacheFactory {

    private static CacheManager cacheManager;
    private static volatile Object lock = new Object();
    private static Logger logger = LoggerFactory.getLogger(EhcacheFactory.class);

    private static CacheManager getCacheManager() {
        if(cacheManager == null) {
           synchronized (EhcacheFactory.class) {
               if(cacheManager == null) {
                    cacheManager = CacheManager.create();
               }
           }
        }
        return cacheManager;
    }

    static Cache getOrAddCache(String cacheName) {
        CacheManager cacheManager = getCacheManager();
        Cache cache = cacheManager.getCache(cacheName);
        if(cache == null) {
            synchronized (lock) {
                cache = cacheManager.getCache(cacheName);
                if(cache == null) {
                    logger.warn("无法找到缓存 [" + cacheName + "]的配置，使用默认配置");
                    cacheManager.addCacheIfAbsent(cacheName);
                    cache = cacheManager.getCache(cacheName);
                    logger.debug("缓存[" + cacheName + "] 启动.");
                }
            }
        }
        return cache;
    }
    @Override
    public void put(String cacheName, Object key, Object value) {
        getOrAddCache(cacheName).put(new Element(key, value));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T get(String cacheName, Object key) {
        Element element = getOrAddCache(cacheName).get(key);
        return element == null ? null : (T) element.getObjectValue();
    }

    @Override
    public List getKeys(String cacheName) {
        return getOrAddCache(cacheName).getKeys();
    }

    @Override
    public void remove(String cacheName, Object key) {
        getOrAddCache(cacheName).remove(key);
    }

    @Override
    public void removeAll(String cacheName) {
        getOrAddCache(cacheName).removeAll();
    }
}
