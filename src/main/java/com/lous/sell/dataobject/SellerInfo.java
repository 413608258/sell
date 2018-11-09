package com.lous.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @ClassName : SellerInfo
 * @Description : TODO
 *
 * @author : Loushuai
 * @since : 2018-11-06
 **/
@Data
@Entity
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;

}
