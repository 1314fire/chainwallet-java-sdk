package org.chainwallet.bo;

import lombok.Data;

@Data
public class GetUserAddrBo {
    // 用户ID
    private String uid;

    // 链类型
    private Integer chain_type;

    // 币类型
    private Integer coin_type;

}
