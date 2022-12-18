package org.chainwallet.bo;

import lombok.Data;

@Data
public class GetBalanceBo {

    // 地址
    private String addr;

    // 链类型
    private Integer chain_type;

    // 币类型
    private Integer coin_type;
}
