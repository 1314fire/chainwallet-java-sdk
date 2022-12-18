package org.chainwallet.vo;

import lombok.Data;

@Data
public class GetWithdrawOrderInfoVo {

    // 链类型
    private Integer chain_type;

    // 币名
    private String coin_name;

    // 地址
    private String addr;

    // 金额
    private String amount;

    // 手续费
    private String fee;

    // 交易时间
    private String time;

    //订单号
    private String trade_no;

    // 交易hash
    private String tx_id;

    // 扩展字段
    private String extra;

    // 状态
    private Integer status;
}
