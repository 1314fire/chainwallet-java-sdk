package org.chainwallet.vo;

import lombok.Data;

@Data
public class PaymentVo {

    // 订单号
    private String order_no;

    // 订单号
    private String plat_no;

    // 付款地址
    private String pay_addr;
}
