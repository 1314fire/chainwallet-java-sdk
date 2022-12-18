package org.chainwallet.bo;

import lombok.Data;

@Data
public class WithdrawOrderListBo {

    // 订单查询开始时间
    private String start_date;

    // 订单查询结束时间
    private String end_date;

    // 交易类型
    private Integer transfer_type;
}
