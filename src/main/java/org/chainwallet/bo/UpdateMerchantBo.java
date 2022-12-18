package org.chainwallet.bo;

import lombok.Data;

@Data
public class UpdateMerchantBo {

    // 商户名称
    private String merchant_name;

    // 回调地址
    private String callback_url;

    // 白名单地址
    private String ip_whites;

    // 白名单状态
    private Integer ip_white_open;
}
