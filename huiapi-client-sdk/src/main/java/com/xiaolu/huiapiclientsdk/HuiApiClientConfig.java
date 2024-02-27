package com.xiaolu.huiapiclientsdk;

import com.xiaolu.huiapiclientsdk.client.HuiApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 林小鹿
 * @version 1.0
 * @create 2024/1/12 11:38
 * @Description sdk 配置类
 */
@Configuration
// 读取配置信息
@ConfigurationProperties("huiapi.client")
@Data
@ComponentScan
public class HuiApiClientConfig {

    private String accessKey;

    private String secretKey;

    @Bean
    public HuiApiClient huiApiClient() {
        return new HuiApiClient(accessKey, secretKey);
    }

}
