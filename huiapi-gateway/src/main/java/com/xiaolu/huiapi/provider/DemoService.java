package com.xiaolu.huiapi.provider;

import java.util.concurrent.CompletableFuture;

/**
 * @author 林小鹿
 * @version 1.0
 * @create 2024/1/16 14:46
 * @Description
 */
public interface DemoService {

    String sayHello(String name);

    default CompletableFuture<String> sayHelloAsync(String name) {
        return CompletableFuture.completedFuture(sayHello(name));
    }
}
