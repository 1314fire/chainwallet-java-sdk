package org.chainwallet.bo;

import lombok.Data;

@Data
public class DeposOrderListBo {

    // 订单查询开始时间
    private String start_date;

    // 订单查询结束时间
    private String end_date;
}
