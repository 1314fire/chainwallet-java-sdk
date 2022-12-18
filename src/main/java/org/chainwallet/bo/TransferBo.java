package org.chainwallet.bo;

import lombok.Data;

@Data
public class TransferBo {
    // 订单号
    private String order;
    // 用户ID
    private String uid;
    // 链类型
    private Integer chain_type;
    // 币类型
    private Integer coin_type;
    // 交易数量
    private String amount;
    // 收款地址
    private String to_addr;
}
