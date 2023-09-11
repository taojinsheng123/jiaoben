package com.tao.Map;

import java.net.URL;
import java.util.List;

public class ZhuDongMap {

    private static String name;

    private static List<String> xiaoguai;

    private static int cengshu;

    private static String mappath = "/map/xiaoguai";

    static {
        System.out.println(2);
        ClassLoader classLoader = ClassLoader.class.getClassLoader();
        URL resource = classLoader.getResource("/map/zhudong");
        System.out.println(resource);
    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
