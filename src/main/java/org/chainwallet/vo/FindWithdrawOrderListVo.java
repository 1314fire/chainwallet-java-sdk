package org.chainwallet.vo;

import lombok.Data;

@Data
public class FindWithdrawOrderListVo {

    private Integer chain_type;

    private String amount;

    private String created_at;

    private Integer order_status;

    private String real_amount;

    private String to_addr;

    private String tx_id;
}
