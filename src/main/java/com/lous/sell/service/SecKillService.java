package com.lous.sell.service;

/**
 * @ClassName : SecKillService
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2019-01-02
 **/
 
public interface SecKillService {

    /**
     * 查询秒杀活动特价商品的信息
     *
     * @param productId
     * @return
     */
    String querySecKillProductInfo(String productId);

    /**
     * 模拟不同用户秒杀同一商品的请求
     *
     * @param productId
     * @return
     */
    void orderProductMockDiffUser(String productId);
}
