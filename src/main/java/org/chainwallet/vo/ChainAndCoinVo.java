package org.chainwallet.vo;

import lombok.Data;

@Data
public class ChainAndCoinVo {

    // 币名
    private String coin_name;

    // 币类型
    private Integer coin_type;

    // 是否支持
    private Integer support;

    // 链类型
    private Integer chain_type;

    // 合约地址
    private String contract;

    // 代币协议
    private String protocol;

    // 精度
    private Integer precision;

    // 是否主币
    private Integer main;
}
