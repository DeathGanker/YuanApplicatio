package com.fengyuan.temp2out.factory;

import cn.hutool.core.bean.BeanUtil;
import com.fengyuan.temp2out.bean.WeChat;

import java.util.Map;
import java.util.Objects;

public class test {
    private String appId;
    private String appSecret;
    private String token;
    private int expireDays;

    // 构造函数、getter和setter方法...

    public static void main(String[] args) {
       WeChat wechat = new WeChat();
       wechat.setOpenAIApiKey("yourAppId");
       wechat.setOpenAIApiBase("yourAppSecret");


        String template = readTemplate("docker-compose-wechat.ftl");


        String output = replacePlaceholders(BeanUtil.beanToMap(wechat), template);
        writeYaml("docker-compose-wechat.yml", output);
    }

    private static String readTemplate(String templateFileName) {
        // 从文件系统中读取模板文件的内容并返回
        // ...
        return "";
    }

    private static String replacePlaceholders(Map<String, Object> map, String template) {
        // 使用对象的属性值替换模板中的占位符
        String output = "";
        // 打印Map中的键值对
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            output = template.replace(entry.getKey(), entry.getValue().toString());
        }
        return output;
    }

    private static void writeYaml(String fileName, String content) {
        // 将content写入到fileName指定的文件中
        // ...
    }
}

