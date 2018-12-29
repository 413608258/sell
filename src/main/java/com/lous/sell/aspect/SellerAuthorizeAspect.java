package com.lous.sell.aspect;

import com.lous.sell.constant.CookieConstant;
import com.lous.sell.constant.RedisConstant;
import com.lous.sell.execption.SellerAuthorizeException;
import com.lous.sell.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName : SellerAuthorizeAspect
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2018-11-09
 **/
 @Aspect
 @Component
 @Slf4j
public class SellerAuthorizeAspect {

     @Autowired
     private StringRedisTemplate redisTemplate;

     @Pointcut("execution(public * com.lous.sell.controller.Seller*.*(..))" +
             "&& !execution(public * com.lous.sell.controller.SellerUserController.*(..))")
     public void verify(){
     }

     @Before("verify()")
     public void doVerify(){
         ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
         HttpServletRequest request = attributes.getRequest();

         //查询cookie
         Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
         if (cookie == null) {
             log.warn("[登录校验] Cookie中查不到token");
             throw new SellerAuthorizeException();
         }

         //去redis中查询
         String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
         if (StringUtils.isEmpty(tokenValue)) {
             log.warn("[登录校验] Redis中查不到token");
             throw new SellerAuthorizeException();
         }
     }
}
