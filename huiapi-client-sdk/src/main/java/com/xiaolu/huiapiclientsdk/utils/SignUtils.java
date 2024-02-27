package com.xiaolu.huiapiclientsdk.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * @author 林小鹿
 * @version 1.0
 * @create 2024/1/12 2:02
 * @Description 签名工具
 */
public class SignUtils {

    /**
     * 生成签名：利用hashMap中的参数配合未传递过去的密钥进行单向加密 (此处使用的是hutool自带的摘要加密算法)
     * @param body
     * @param secretKey
     * @return
     */
    public static String getSign(String body, String secretKey) {
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        String content = body + "$" + secretKey;
        // 5393554e94bf0eb6436f240a4fd71282
        return md5.digestHex(content);
    }
}
