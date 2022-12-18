package org.chainwallet.vo;

import lombok.Data;

@Data
public class GetUserAddressVo {
    // 链类型
    private Integer chain;

    // 地址
    private String addr;

    // 备注
    private String memo;
}
