package com.flash.message;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 作者 :hywang
 *
 * @version 创建时间：2019年9月12日 下午12:20:25
 *
 * @version 1.0
 */
@RestController
public class MockController {

    @RequestMapping("/mock")
    public String mock() {
        System.out.println("mock request");
        SimpleDateFormat format = new SimpleDateFormat("yyyymmddHHmmss");
        String date = format.format(new Date());
        String msgId = getFixLenthString(10);
        String tmp = date + ",0" + "\r" + msgId;
        return tmp;
    }

    private String getFixLenthString(int strLength) {
        Random rm = new Random();
        // 获得随机数
        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);
        // 将获得的获得随机数转化为字符串
        String fixLenthString = String.valueOf(pross);
        // 返回固定的长度的随机数
        return fixLenthString.substring(2, strLength + 1);
    }

}
