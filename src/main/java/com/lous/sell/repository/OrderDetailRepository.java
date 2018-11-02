package com.lous.sell.repository;

import com.lous.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * <p>
 * 订单详情 Mapper 接口
 * </p>
 *
 * @author Loushuai
 * @since 2018-11-01
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

}
