package org.chainwallet.bo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GetPaymentBo {

    // 用户ID
    private String uid;

    // 交易数量
    private BigDecimal amount;

    // 链类型
    private Integer chain_type;

    // 币类型
    private Integer coin_type;

    // 订单号
    private String order_no;
}
