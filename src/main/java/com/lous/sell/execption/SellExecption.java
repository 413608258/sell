package com.lous.sell.execption;

import com.lous.sell.enums.ResultEnum;

/**
 * @ClassName : SellExecption
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2018-11-02
 **/
 
public class SellExecption extends RuntimeException{

    private Integer code;

    public SellExecption(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellExecption(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
