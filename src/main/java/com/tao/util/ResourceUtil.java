package com.tao.util;

public class ResourceUtil {

    private static String path=ResourceUtil.class.getClassLoader().getResource("").getPath();

    public static String getResourcesPath(){
        //
        return path;
    }
}
