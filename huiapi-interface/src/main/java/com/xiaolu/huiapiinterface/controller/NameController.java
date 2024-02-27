package com.xiaolu.huiapiinterface.controller;

import com.xiaolu.huiapiclientsdk.model.User;
import com.xiaolu.huiapiclientsdk.utils.SignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * @author 林小鹿
 * @version 1.0
 * @create 2024/1/11 22:05
 * @Description 名称 API
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/get")
    public String getNameByGet(String name) {
        return "GET 你的名字是" + name;
    }

    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是" + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request) {
        String[] str = new String[] {"六味地黄丸", "遥遥领先", "纯爱战士", "生命体征平稳，精神状态良好", "你人还怪好嘞", "泰裤辣"};

        String result =  "POST 你的名字是" + user.getUsername() + str[new Random().nextInt(str.length)];

        return result;
    }

    @GetMapping("/error")
    public String getByError() {
        return "接口开发中。。。";
    }
}
