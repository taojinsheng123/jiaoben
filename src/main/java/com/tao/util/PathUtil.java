package com.tao.util;

import java.io.File;

public class PathUtil {
    public static String getRootPath(){
        ClassLoader classLoader = PathUtil.class.getClassLoader();

        // 获取 resources 文件夹的相对路径
        String resourcesPath = "resources";

        // 使用类加载器获取资源文件夹的 URL
        java.net.URL resourceFolderURL = classLoader.getResource(resourcesPath);

        return new File(resourceFolderURL.getFile()).getAbsolutePath();

    }
}
