package com.lous.sell.handler;

import com.lous.sell.VO.ResultVO;
import com.lous.sell.config.ProjectUrlConfig;
import com.lous.sell.execption.ResponseBankException;
import com.lous.sell.execption.SellException;
import com.lous.sell.execption.SellerAuthorizeException;
import com.lous.sell.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName : ExceptionHandler
 * @Description :
 *
 * @author : Loushuai
 * @since : 2018-12-27
 **/
 
@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    //拦截登录异常
    @ExceptionHandler(value = SellerAuthorizeException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("redirect:"
                .concat(projectUrlConfig.getWechatOpenAuthorize())
                .concat("/sell/wechat/qrAuthorize")
                .concat("?returnUrl=")
                .concat(projectUrlConfig.getSell())
                .concat("/sell/seller/login"));
    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    /**
     * TODO: @ResponseStatus 注解可以设置请求返回的状态码 Status(不设置默认：200，即请求是成功的)
     */
    //@ResponseStatus(HttpStatus.FORBIDDEN)
    public ResultVO handlerSellerException(SellException e) {
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(value = ResponseBankException.class)
    /**
     * TODO: @ResponseStatus 注解可以设置请求返回的状态码 Status(不设置默认：200，即请求是成功的)
     */
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handlerResponseBankException(){
    }
}
