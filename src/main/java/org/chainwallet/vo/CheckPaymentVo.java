package org.chainwallet.vo;

import lombok.Data;

@Data
public class CheckPaymentVo {

    private String order_no;

    private String plat_no;

    private String amount;

    private String real_amount;

    private Integer status;
}
