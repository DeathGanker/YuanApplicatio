package com.fengyuan.temp2out.factory;

import cn.hutool.core.io.FileUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.Map;

/**
 * 模版生成可执行文件的工厂类
 */
public class Temp2outFactory {

    //模板配置对象
    private Configuration cfg;

    // 模板目录
    private String ftlPath;

    // 输出yaml
    private String yamlPath;

    private String dirPath;

    private File yamlFile = null;

    /**
     * 初始化配置
     */
    public Temp2outFactory() {
        cfg = new Configuration();
        File yamlFile = null;
        try {
            yamlFile = new File(FileUtil.file(".", "temp/path" + File.separator + "temp").getCanonicalPath());
            cfg.setDirectoryForTemplateLoading(yamlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Temp2outFactory(String url) {
        cfg = new Configuration();
        try {
            yamlFile = new File(FileUtil.file(".", "temp/path"  + File.separator  + url).getCanonicalPath());
            cfg.setDirectoryForTemplateLoading(yamlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成yaml
     * @param map
     * @param ftlName
     * @return
     */
    public FileInputStream process(Map<String, Object> map, String ftlName, String buName){
        try {
            process(map, ftlName, "out", buName, "yaml");
            return new FileInputStream(FileUtil.file(".", "temp/path"  + File.separator +  "out" + File.separator + buName + ".yaml").getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成文件到指定路径
     * @param map
     * @param ftlName
     * @param outPath
     * @param buName
     * @param fileType
     * @return
     */
    public boolean process(Map<String, Object> map, String ftlName, String outPath, String buName, String fileType){
        try {
            Template template = cfg.getTemplate(ftlName + ".ftl");
            template.process(map, new FileWriter(new File(FileUtil.file(".", "temp/path"  + File.separator +  outPath + File.separator + buName + "." + fileType).getCanonicalPath())));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 生成 url 里所有文件
     * @return
     */
    public int process(Map<String, Object> map, String fileType) {

        if (yamlFile != null && yamlFile.isDirectory()) {
            for (String fileName : yamlFile.list()) {
                System.err.println("fileName:"+fileName);
                process(map, fileName.split("\\.")[0], "out" + File.separator + yamlFile.getParentFile().getName() + File.separator + yamlFile.getName(), fileName.split("\\.")[0], fileType);
                System.err.println("");
            }
        }
        return 0;
    }
    /**
     * 生成 url 里所有文件
     * @return
     */
    public int processForDocker(Map<String, Object> map, String fileType) {

        if (yamlFile != null && yamlFile.isDirectory()) {
            for (String fileName : yamlFile.list()) {
                System.err.println("fileName:"+fileName);
                process(map, fileName.split("\\.")[0], "out" + File.separator + yamlFile.getParentFile().getParentFile().getName() + File.separator + yamlFile.getName(), fileName.split("\\.")[0], fileType);
                System.err.println("");
            }
        }
        return 0;
    }

    public String getFtlPath() {
        return ftlPath;
    }

    public void setFtlPath(String ftlPath) {
        this.ftlPath = ftlPath;
    }

    public String getYamlPath() {
        return yamlPath;
    }

    public void setYamlPath(String yamlPath) {
        this.yamlPath = yamlPath;
    }

    public static void main(String[] args) {

        File yamlFile = new File("/Users/xiehu/IdeaProjects/YuanApplication/src/main/java/com/fengyuan/temp2out/ftlResource/docker-compose-wechat.ftl");
        System.out.println(yamlFile.getParentFile().getName() + File.separator + yamlFile.getName());
    }
}
