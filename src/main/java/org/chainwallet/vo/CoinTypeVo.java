package org.chainwallet.vo;

import lombok.Data;

@Data
public class CoinTypeVo {
    private String coin_name;

    private Integer coin_type;

    private Integer support;

    private Integer chain_type;

    private String contract;

    private String protocol;

    private Integer precision;

    private Integer main;
}
