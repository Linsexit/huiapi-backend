package com.xiaolu.huiapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.xiaolu.huiapiclientsdk.model.User;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static com.xiaolu.huiapiclientsdk.utils.SignUtils.getSign;

/**
 * @author 林小鹿
 * @version 1.0
 * @create 2024/1/11 22:38
 * @Description 调用第三方接口的客户端
 */
public class HuiApiClient {

    private static final String GATEWAY_HOST = "http://localhost:8107";
    private String accessKey;

    private String secretKey;

    public HuiApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getNameByGet(String name) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.get(GATEWAY_HOST + "/api/name/get", paramMap);
        // System.out.println(result);
        return result;

    }

    public String getNameByPost(String name) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.post(GATEWAY_HOST + "/api/name/post", paramMap);
        // System.out.println(result);
        return result;
    }

    /**
     * 发送http请求
     * @param user
     * @return
     */
    public String getUsernameByPost(User user) {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST + "/api/name/user")
                .charset(StandardCharsets.UTF_8)
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        // System.out.println(result);
        return result;
    }

    private Map<String, String> getHeaderMap(String body) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accessKey);
        // secretKey不能直接发送给后端 (怕被拦截)
        // hashMap.put("secretKey", secretKey);
        // 随机数 (防止重放请求)
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        // 用户传递的参数
        hashMap.put("body", body);
        // 时间戳
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        // 签名加密
        hashMap.put("sign", getSign(body, secretKey));
        return hashMap;
    }


}
