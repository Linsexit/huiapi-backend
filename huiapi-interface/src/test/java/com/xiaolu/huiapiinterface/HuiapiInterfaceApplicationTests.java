package com.xiaolu.huiapiinterface;

import com.xiaolu.huiapiclientsdk.client.HuiApiClient;
import com.xiaolu.huiapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class HuiapiInterfaceApplicationTests {

    @Resource
    private HuiApiClient huiApiClient;

    @Test
    void contextLoads() {
        // String result = huiApiClient.getNameByGet("xiaolu");
        // User user = new User();
        // user.setUsername("alibaba");
        // String usernameByPost = huiApiClient.getUsernameByPost(user);
        // System.out.println(result);
        // System.out.println(usernameByPost);


    }

}
