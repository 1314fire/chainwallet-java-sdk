package org.chainwallet.vo;

import lombok.Data;

@Data
public class GetPaymentVo {

    private String order_no;

    private String plat_no;

    private String pay_addr;
}
