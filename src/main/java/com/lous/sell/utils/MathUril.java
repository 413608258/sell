package com.lous.sell.utils;

/**
 * @ClassName : MathUril
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2018-11-05
 **/
 
public class MathUril {

    private static final Double MONEY_RANGE = 0.01;

    public static Boolean equals(Double d1, Double d2){
        Double result = Math.abs(d1 - d2);
        if (result < MONEY_RANGE) {
            return true;
        }else {
            return false;
        }
    }
}
