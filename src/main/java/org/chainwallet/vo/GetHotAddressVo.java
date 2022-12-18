package org.chainwallet.vo;

import lombok.Data;

@Data
public class GetHotAddressVo {

    // 链类型
    private Integer chain;

    // 归集地址
    private String hot_addr;

    // 手续费地址
    private String fee_addr;
}
