package com.kevin.manage.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ValueFilter;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZGJ
 * @date 2017/8/28 23:40
 **/
@Configuration("defaultFastJsonConfig")
@ConditionalOnClass(com.alibaba.fastjson.JSON.class)
@ConditionalOnMissingBean(FastJsonHttpMessageConverter4.class)
@ConditionalOnWebApplication
public class DefaultFastJsonConfig {
    @Bean
    public FastJsonHttpMessageConverter4 fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter4 converter = new FastJsonHttpMessageConverter4();
        converter.setFastJsonConfig(fastJsonConfig());
        converter.setSupportedMediaTypes(getSupportedMediaType());
        return fastJsonHttpMessageConverter();
    }
    public FastJsonConfig fastJsonConfig() {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue);
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
//        ValueFilter valueFilter = new ValueFilter() {
//            @Override
//            public Object process(Object o, String s, Object o1) {
//                if(o1 == null) {
//                    o1 = "";
//                }
//                return o1;
//            }
//        };
        ValueFilter valueFilter = (o, s, o1) -> {
            if(o1 == null) {
                o1 = "";
            }
            return o1;
        };
        fastJsonConfig.setCharset(Charset.forName("utf-8"));
        fastJsonConfig.setSerializeFilters(valueFilter);
        return fastJsonConfig;
    }

    public List<MediaType> getSupportedMediaType() {
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        return mediaTypes;
    }
}
