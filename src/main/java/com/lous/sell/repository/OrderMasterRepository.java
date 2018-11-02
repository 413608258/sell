package com.lous.sell.repository;

import com.lous.sell.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author Loushuai
 * @since 2018-11-01
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

}
