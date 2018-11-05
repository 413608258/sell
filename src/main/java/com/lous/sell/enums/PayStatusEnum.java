package com.lous.sell.enums;

import lombok.Getter;

/**
 * @ClassName : OrderStatusEnum
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2018-11-02
 **/
@Getter
public enum PayStatusEnum {
    WAIT(0, "新订单"),
    SUCCESS(1, "支付成功")
    ;

    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
