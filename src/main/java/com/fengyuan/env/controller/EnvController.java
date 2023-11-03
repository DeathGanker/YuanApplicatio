package com.fengyuan.env.controller;

import com.fengyuan.env.service.ModelService;
import com.fengyuan.utils.YamlUtils;

public class EnvController {
    ModelService   modelService;
    //传入文件路径，解析文件内容
    public void parseFile (String filePath) {
        //根据传入的filePath读取文件内
        YamlUtils.readYaml(filePath);
        Object valueByKey = YamlUtils.getValueByKey("harbor.version");
        Object deployMode = YamlUtils.getValueByKey("deploy.mode");
        System.err.println("deployMode:" + deployMode);
        String version = (String) valueByKey;
        System.out.println("开始读取配置文件。。。。。。");
        System.out.println("DataOS" + version + " 安装程序启动中....");
//        modelService.ModelType(deployMode.toString());
    }
}
