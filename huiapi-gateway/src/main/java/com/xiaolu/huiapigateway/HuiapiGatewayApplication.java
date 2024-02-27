package com.xiaolu.huiapigateway;

import com.xiaolu.huiapi.provider.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class
})
@EnableDubbo
public class HuiapiGatewayApplication {

    @DubboReference
    private DemoService demoService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(HuiapiGatewayApplication.class, args);
        HuiapiGatewayApplication application = context.getBean(HuiapiGatewayApplication.class);
        String result = application.doSayHello("world");
        System.out.println("result: " + result);
    }

    public String doSayHello(String name) {
        return demoService.sayHello(name);
    }


    // @Bean
    // public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    //     return builder.routes()
    //             .route("baidu_route", r -> r.path("/baidu")
    //                     .uri("https://www.baidu.com"))
    //             .route("hui_route", r -> r.path("/hui")
    //                     .uri("http://center.deerlonger.top"))
    //             .build();
    // }
}
