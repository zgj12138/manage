package com.kevin.manage.cache;

/**
 * @author zhangguoji
 * @date 2017/8/29 16:26
 */
public abstract class BaseCacheFactory implements ICache {

    @SuppressWarnings("unchecked")
    @Override
    public <T> T get(String cacheName, Object key, ILoader iLoader) {
        Object data = get(cacheName, key);
        if(data == null) {
            data = iLoader.load();
            put(cacheName, key, data);
        }
        return (T) data;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T get(String cacheName, Object key, Class<? extends ILoader> iLoaderClass) {
        Object data = get(cacheName, key);
        if(data == null) {
            ILoader dataLoader = null;
            try {
                dataLoader = iLoaderClass.newInstance();
                data = dataLoader.load();
                put(cacheName, key, data);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return (T) data;
    }
}
