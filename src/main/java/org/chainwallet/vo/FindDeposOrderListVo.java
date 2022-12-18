package org.chainwallet.vo;

import lombok.Data;

@Data
public class FindDeposOrderListVo {

    private Integer coin_type;

    private String amount;

    private String real_amount;

    private String txId;

    private Integer order_status;

    private String created_at;

    private String to_addr;
}
