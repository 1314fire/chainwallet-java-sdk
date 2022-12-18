package org.chainwallet.bo;

import lombok.Data;

@Data
public class UserBalanceBo {
    // 商户 ID
    private String merchant_id;

    // APP ID
    private String app_id;

    // 用户 ID
    private String uid;
}
