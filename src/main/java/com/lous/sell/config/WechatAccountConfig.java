package com.lous.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLContext;

/**
 * @ClassName : WechatAccountConfig
 * @Description :
 *
 * @author : Loushuai
 * @since : 2018-11-05
 **/
 
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

    private String mpAppId;

    private String mpAppSecret;

    private String mchId;
    private String mchKey;
    private String keyPath;
    private String notifyUrl;
}
