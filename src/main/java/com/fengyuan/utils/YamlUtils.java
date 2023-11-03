package com.fengyuan.utils;



import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 操作yaml文件的类
 * author：xiehu
 */
public class YamlUtils {

    private static Map<String, Map<String, Object>> properties = new HashMap<>();

    /**
     * 读取yaml文件
     * @param yamlPath
     * @return
     */
    public static Map<String, Map<String, Object>> readYaml(String yamlPath) {

        Yaml yaml = new Yaml();

        InputStream in;
        try{
            File file = new File(yamlPath);
            in = new FileInputStream(file);
            return properties = yaml.loadAs(in, HashMap.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

    }

    /**
     * get yaml property
     *
     * @param key
     * @return
     */
    public static Object getValueByKey(String key) {
        String separator = ".";
        String[] separatorKeys = null;
        if (key.contains(separator)) {
            separatorKeys = key.split("\\.");
        } else {
            return properties.get(key);
        }
        Map<String, Map<String, Object>> finalValue = new HashMap<>();
        for (int i = 0; i < separatorKeys.length - 1; i++) {
            if (i == 0) {
                finalValue = (Map) properties.get(separatorKeys[i]);
                continue;
            }
            if (finalValue == null) {
                break;
            }
            finalValue = (Map) finalValue.get(separatorKeys[i]);
        }
        if (finalValue != null){
            return finalValue.get(separatorKeys[separatorKeys.length - 1]);
        }else{
            return null;
        }
    }
}
