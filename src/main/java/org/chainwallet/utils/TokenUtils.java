package org.chainwallet.utils;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;

import java.sql.DataTruncation;
import java.util.*;

public class TokenUtils {

    /**
     * 生成TOKEN
     * @param appId
     * @param secret
     * @param param
     * @return
     */
    public static String makeToken(String appId, String secret, Map<String, String> param){
        TreeMap<String, String> map2 = CollUtil.sort(param, String::compareTo);
        Set<String> keySet = map2.keySet();
        List<String> paramString = new LinkedList<String >();
        paramString.add(appId);
        paramString.add(secret);
        for (String key1: keySet) {
            paramString.add(key1 + "=" + Convert.toStr(param.get(key1)));
        }
        if (keySet.size() == 0){
            paramString.add("");
        }

        return SecureUtil.md5(StrUtil.join("&", paramString));
    }
}
