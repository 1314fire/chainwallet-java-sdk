package org.chainwallet.vo;

import lombok.Data;

@Data
public class UserBalanceVo {

    private Integer coinType;

    private String totalAmount;

    private String validAmount;

    private String chainAmount;

    private String frozeAmount;

    private Integer chainType;

    private String addr;
}
