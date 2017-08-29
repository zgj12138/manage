package com.kevin.manage.base.warpper;

import java.util.List;
import java.util.Map;

/**
 * 控制器查询结果的包装类基类
 * @author zhangguoji
 * @date 2017/8/29 18:03
 */
public abstract class BaseControllerWarpper {

    private Object object = null;

    public BaseControllerWarpper(Object object) {
        this.object = object;
    }

    @SuppressWarnings("unchecked")
    public Object warp() {
        if(this.object instanceof List) {
            List<Map<String, Object>> list = (List<Map<String, Object>>) this.object;
            for(Map<String, Object> map : list) {
                warpTheMap(map);
            }
            return list;
        } else if (this.object instanceof Map) {
            Map<String, Object> map = (Map<String, Object>) this;
            warpTheMap(map);
            return map;
        } else {
            return this.object;
        }
    }

    protected abstract void warpTheMap(Map<String, Object> map);
}
