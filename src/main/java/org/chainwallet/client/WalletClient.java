package org.chainwallet.client;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import org.chainwallet.bo.*;
import org.chainwallet.utils.TokenUtils;
import org.chainwallet.vo.*;

import java.util.*;
import java.util.List;

public class WalletClient {

    private HttpRequest httpRequest;

    private String appId;

    private String token;

    private String domain = "http://127.0.0.1:8802/finance";

    public WalletClient(){}

    public WalletClient(String appId, String token){
        this.appId = appId;
        this.token = token;
    }

    public void init(String url, Map<String, String> param){
        httpRequest = HttpRequest.post(domain + url).header("App", appId).header("Access-Token", TokenUtils.makeToken(appId, token, param));
    }

    public List<ChainAndCoinVo> getChainAndCoin(ChainAndCoinBo bo){
        init("/chain_coin", beanToMap(bo));
        String res = httpRequest.body(JSONObject.toJSONString(bo)).execute().body();
        JSONObject resObj = JSONObject.parseObject(res);
        if (resObj.getInteger("code") != 0){
            throw new RuntimeException(resObj.getString("msg"));
        }
        List<ChainAndCoinBo> list = new ArrayList<>();

        return resObj.getObject("data", list.getClass());
    }

    public Boolean toTransfer(TransferBo bo){
        init("/transfer", beanToMap(bo));
        String res = httpRequest.body(JSONObject.toJSONString(bo)).execute().body();

        JSONObject resObj = JSONObject.parseObject(res);
        if (resObj.getInteger("code") != 0){
            throw new RuntimeException(resObj.getString("msg"));
        }
        return true;
    }

    public GetUserAddressVo getUserAddress(GetUserAddrBo bo){
        init("/getAddress", beanToMap(bo));
        String res = httpRequest.body(JSONObject.toJSONString(bo)).execute().body();
        JSONObject resObj = JSONObject.parseObject(res);
        if (resObj.getInteger("code") != 0){
            throw new RuntimeException(resObj.getString("msg"));
        }

        return resObj.getObject("data", GetUserAddressVo.class);
    }

    public GetHotAddressVo getHotAddress(GetHotAddrBo bo){
        init("/getHotAddress", beanToMap(bo));
        String res = httpRequest.body(JSONObject.toJSONString(bo)).execute().body();
        JSONObject resObj = JSONObject.parseObject(res);
        if (resObj.getInteger("code") != 0){
            throw new RuntimeException(resObj.getString("msg"));
        }

        return resObj.getObject("data", GetHotAddressVo.class);
    }

    public String suggestGasPrice(){
        init("/suggestGasPrice", new HashMap<>());
        String res = httpRequest.execute().body();
        JSONObject resObj = JSONObject.parseObject(res);
        if (resObj.getInteger("code") != 0){
            throw new RuntimeException(resObj.getString("msg"));
        }

        return resObj.getString("data");
    }

    public String getBalance(GetBalanceBo bo){
        init("/balance", beanToMap(bo));
        String res = httpRequest.body(JSONObject.toJSONString(bo)).execute().body();
        JSONObject resObj = JSONObject.parseObject(res);
        if (resObj.getInteger("code") != 0){
            throw new RuntimeException(resObj.getString("msg"));
        }
        return resObj.getString("data");
    }

    public Boolean updateMerchant(UpdateMerchantBo bo){
        init("/update/merchant", beanToMap(bo));
        String res = httpRequest.body(JSONObject.toJSONString(bo)).execute().body();
        JSONObject resObj = JSONObject.parseObject(res);
        if (resObj.getInteger("code") != 0){
            throw new RuntimeException(resObj.getString("msg"));
        }

        return true;
    }

    public List<GetMerchantCollectBalanceVo> getMerchantCollectBalance(CollectBalanceBo bo){
        init("/getMerchantCollectBalance", beanToMap(bo));
        String res = httpRequest.body(JSONObject.toJSONString(bo)).execute().body();
        JSONObject resObj = JSONObject.parseObject(res);
        if (resObj.getInteger("code") != 0){
            throw new RuntimeException(resObj.getString("msg"));
        }
        List<GetMerchantCollectBalanceVo> list = new ArrayList<>();
        return resObj.getObject("data", list.getClass());
    }

    public List<UserBalanceVo> getUserBalance(UserBalanceBo bo){
        init("/getUserBalance", beanToMap(bo));
        String res = httpRequest.body(JSONObject.toJSONString(bo)).execute().body();
        JSONObject resObj = JSONObject.parseObject(res);
        if (resObj.getInteger("code") != 0){
            throw new RuntimeException(resObj.getString("msg"));
        }
        List<UserBalanceVo> list = new ArrayList<>();
        return resObj.getObject("data", list.getClass());
    }

    public GetWithdrawOrderInfoVo getWithdrawOrderInfo(WithdrawOrderInfoBo bo){
        init("/getWithdrawOrderInfo", beanToMap(bo));
        String res = httpRequest.body(JSONObject.toJSONString(bo)).execute().body();
        JSONObject resObj = JSONObject.parseObject(res);
        if (resObj.getInteger("code") != 0){
            throw new RuntimeException(resObj.getString("msg"));
        }

        return resObj.getObject("data", GetWithdrawOrderInfoVo.class);
    }

    public List<FindWithdrawOrderListVo> findWithdrawOrderList(WithdrawOrderListBo bo){
        init("/findWithdrawOrderList", beanToMap(bo));
        String res = httpRequest.body(JSONObject.toJSONString(bo)).execute().body();
        JSONObject resObj = JSONObject.parseObject(res);
        if (resObj.getInteger("code") != 0){
            throw new RuntimeException(resObj.getString("msg"));
        }
        List<FindWithdrawOrderListVo> list = new ArrayList<>();
        return resObj.getObject("data", list.getClass());
    }

    public List<FindDeposOrderListVo> findDeposOrderList(DeposOrderListBo bo){
        init("/findDeposOrderList", beanToMap(bo));
        String res = httpRequest.body(JSONObject.toJSONString(bo)).execute().body();
        JSONObject resObj = JSONObject.parseObject(res);
        if (resObj.getInteger("code") != 0){
            throw new RuntimeException(resObj.getString("msg"));
        }
        List<FindDeposOrderListVo> list = new ArrayList<>();
        return resObj.getObject("data", list.getClass());
    }

    public Map getChainAndCoinList(){
        init("/getChainAndCoinList", new HashMap<>());
        Map<String, Object> map = new HashMap<>();
        String res = httpRequest.execute().body();
        JSONObject resObj = JSONObject.parseObject(res);
        if (resObj.getInteger("code") != 0){
            throw new RuntimeException(resObj.getString("msg"));
        }
        JSONObject data = resObj.getJSONObject("data");
        List<ChainTypeVo> chainTypeVos = new ArrayList<>();
        List<CoinTypeVo> coinTypeVos = new ArrayList<>();

        chainTypeVos.addAll(data.getObject("chain_type", chainTypeVos.getClass()));
        coinTypeVos.addAll(data.getObject("coin_type", coinTypeVos.getClass()));

        Map<String, Object> map1 = new HashMap<>();
        map1.put("chain_type", chainTypeVos);
        map1.put("coin_type", coinTypeVos);
        return map1;
    }

    public GetPaymentVo getPayment(GetPaymentBo bo){
        init("/depos", beanToMap(bo));
        String res = httpRequest.body(JSONObject.toJSONString(bo)).execute().body();
        JSONObject resObj = JSONObject.parseObject(res);
        if (resObj.getInteger("code") != 0){
            throw new RuntimeException(resObj.getString("msg"));
        }
        return resObj.getObject("data", GetPaymentVo.class);
    }

    public CheckPaymentVo checkPayment(CheckPaymentBo bo){
        init("/checkPayment", beanToMap(bo));
        String res = httpRequest.body(JSONObject.toJSONString(bo)).execute().body();
        JSONObject resObj = JSONObject.parseObject(res);
        if (resObj.getInteger("code") != 0){
            throw new RuntimeException(resObj.getString("msg"));
        }
        return resObj.getObject("data", CheckPaymentVo.class);
    }

    public static Map beanToMap(Object object){
        return JSONObject.parseObject(JSONObject.toJSONString(object),Map.class);
    }
}
