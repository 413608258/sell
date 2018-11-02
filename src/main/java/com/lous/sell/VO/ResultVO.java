package com.lous.sell.VO;

import lombok.Data;

/**
 * @ClassName : ResultVO
 * @Description : http请求返回的最外层对象
 *
 * @author : Loushuai
 * @since : 2018-11-01
 **/
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 具体内容
     */
    private T data;

}
