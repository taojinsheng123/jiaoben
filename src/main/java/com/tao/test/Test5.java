package com.tao.test;

import org.sikuli.script.*;

public class Test5 {
    public static void main(String[] args) {
        Screen screen = new Screen();

        // 定义特征图像文件的路径
        String featureImagePath = "/Users/taojinsheng/Pictures/dd.sikuli/test2.sikuli/1694073176496.png";

        try {
            // 创建一个模式，使用特征图像
            Pattern featurePattern = new Pattern(featureImagePath);

            // 在整个屏幕中查找特征图像
            Match match = screen.find(featurePattern);

            // 如果找到了匹配图像
            if (match != null) {
                // 输出匹配的位置
                System.out.println("找到特征图像坐标: X=" + match.getX() + ", Y=" + match.getY());
                screen.hover(match);
            } else {
                System.out.println("未找到特征图像");
            }
        } catch (FindFailed e) {
            e.printStackTrace();
        }
    }
}
