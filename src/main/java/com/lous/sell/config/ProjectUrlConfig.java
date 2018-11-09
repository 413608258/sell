package com.lous.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName : ProjectUrl
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2018-11-07
 **/
 @Data
 @ConfigurationProperties(prefix = "project-url")
 @Component
public class ProjectUrlConfig {
    /**
     * 微信公众平台授权url
     */
     public String wechatMpAuthorize;
    /**
     * 微信开放平台授权url
     */
     public String wechatOpenAuthorize;
    /**
     * 点餐系统
     */
    public  String sell;
}
