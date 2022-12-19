import com.alibaba.fastjson.JSONObject;
import org.chainwallet.bo.*;
import org.chainwallet.client.WalletClient;
import org.chainwallet.vo.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class WalletClientTest {

    private static String appId = "20202112233";

    private static String token = "YnQGCbCurtNuQEDGKbUAXQktH372lbFW";

    private static String domain = "http://127.0.0.1:8802/finance";

    private static String merchantId = "1";

    public static void main(String[] args) {

        WalletClient walletClient = new WalletClient(WalletClientTest.appId, WalletClientTest.token, WalletClientTest.domain);

        // 获取网络和币的配置表
        ChainAndCoinBo bo = new ChainAndCoinBo();
        bo.setApp_id(WalletClientTest.appId);
        bo.setMerchant_id(WalletClientTest.merchantId);
        List<ChainAndCoinVo> list = walletClient.getChainAndCoin(bo);
        System.out.println(JSONObject.toJSONString(list));

        // 转账
        TransferBo bo1 = new TransferBo();
        bo1.setUid("0001");
        bo1.setAmount("1");
        bo1.setOrder("OrderSn-001");
        bo1.setChain_type(1);
        bo1.setCoin_type(1);
        bo1.setTo_addr("aabc");
        Boolean res = walletClient.toTransfer(bo1);
        System.out.println(res);

        // 获取用户地址
        GetUserAddrBo bo2 = new GetUserAddrBo();
        bo2.setChain_type(2);
        bo2.setCoin_type(3);
        bo2.setUid("104725");
        GetUserAddressVo res2 = walletClient.getUserAddress(bo2);
        System.out.println(res2);

        // 获取服务商地址
        GetHotAddrBo bo3 = new GetHotAddrBo();
        bo3.setChain_type(1);
        GetHotAddressVo res3 = walletClient.getHotAddress(bo3);
        System.out.println(res3);

        // 获取建议油费地址
        String res4 = walletClient.suggestGasPrice();
        System.out.println(res4);

        // 获取余额
        GetBalanceBo bo5 = new GetBalanceBo();
        bo5.setChain_type(2);
        bo5.setCoin_type(3);
        bo5.setAddr("TYxpVgdRs7FURtgtX8p4tcRk14z5VAzdX5");
        String res5 = walletClient.getBalance(bo5);
        System.out.println(res5);

        // 查询支持的所有链类型和币类型
        Map res6 = walletClient.getChainAndCoinList();
        System.out.println(JSONObject.toJSONString(res6));

        // 更新商户
        UpdateMerchantBo bo7 = new UpdateMerchantBo();
        bo7.setIp_whites("http://127.0.0.1");
        bo7.setCallback_url("https://japi.dev.acebetsabo.com/usdtcallback");
        Boolean res7 = walletClient.updateMerchant(bo7);
        System.out.println(res7);

        // 获取商户归集余额
        CollectBalanceBo bo8 = new CollectBalanceBo();
        bo8.setApp_id(WalletClientTest.appId);
        bo8.setMerchant_id(WalletClientTest.merchantId);
        List<GetMerchantCollectBalanceVo> res8 = walletClient.getMerchantCollectBalance(bo8);
        System.out.println(JSONObject.toJSONString(res8));

        // 获取用户余额
        UserBalanceBo bo9 = new UserBalanceBo();
        bo9.setApp_id(WalletClientTest.appId);
        bo9.setMerchant_id(WalletClientTest.merchantId);
        bo9.setUid("104725");
        List<UserBalanceVo> res9 = walletClient.getUserBalance(bo9);
        System.out.println(JSONObject.toJSONString(res9));

        // 获取提币订单详情
        WithdrawOrderInfoBo bo10 = new WithdrawOrderInfoBo();
        bo10.setOrder_no("wdcd4jv5973rhrf6o6bs00");
        GetWithdrawOrderInfoVo res10 = walletClient.getWithdrawOrderInfo(bo10);
        System.out.println(JSONObject.toJSONString(res10));

        // 获取提币订单列表
        WithdrawOrderListBo bo11 = new WithdrawOrderListBo();
        List<FindWithdrawOrderListVo> res11 = walletClient.findWithdrawOrderList(bo11);
        System.out.println(JSONObject.toJSONString(res11));

        // 获取存款订单列表
        DeposOrderListBo bo12 = new DeposOrderListBo();
        List<FindDeposOrderListVo> res12 = walletClient.findDeposOrderList(bo12);
        System.out.println(JSONObject.toJSONString(res12));

        // 获取收银台地址
        GetPaymentBo bo13 = new GetPaymentBo();
        bo13.setUid("10000");
        bo13.setAmount(BigDecimal.valueOf(200));
        bo13.setChain_type(1);
        bo13.setCoin_type(2);
        bo13.setOrder_no("123321123");
        GetPaymentVo res13 = walletClient.getPayment(bo13);
        System.out.println(JSONObject.toJSONString(res13));

        // 查询收银台订单
        CheckPaymentBo bo14 = new CheckPaymentBo();
        bo14.setPlat_no("8cpaycefgk9o48dr1u92957rg");
        CheckPaymentVo res14 = walletClient.checkPayment(bo14);
        System.out.println(JSONObject.toJSONString(res14));
    }
}
