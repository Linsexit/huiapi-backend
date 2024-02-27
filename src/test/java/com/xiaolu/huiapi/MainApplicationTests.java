package com.xiaolu.huiapi;

import com.xiaolu.huiapi.config.WxOpenConfig;
import com.xiaolu.huiapiclientsdk.client.HuiApiClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * 主类测试
 *
 * @author 林小鹿

 */
@SpringBootTest
class MainApplicationTests {

    @Resource
    private WxOpenConfig wxOpenConfig;

    @Resource
    private HuiApiClient huiApiClient;

    @Test
    void contextLoads() {
        // System.out.println(wxOpenConfig);
        // User user = new User();
        // user.setUsername("alibaba");
        // String usernameByPost = huiApiClient.getUsernameByPost(user);
        // System.out.println(usernameByPost);
    }

}
