package com.fengyuan;

import com.fengyuan.env.controller.EnvController;

import java.io.File;

public class Main {

    static EnvController envController = new EnvController();
        /**
     * 主方法，程序的入口
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        System.out.println("这是一个主程序入口，用于添加项目的描述信息");
        System.out.println("另外这里还将获取一些环境变量，并且提供给全局使用");

        //获取工程下面的配置文件
        System.out.println();
        File file = new File("baseInfo.yml");
        if (file.exists()) {
            envController.parseFile(file.getAbsolutePath());
            System.out.println("配置文件存在");
        } else {
            System.out.println("配置文件不存在");
        }
    }

}