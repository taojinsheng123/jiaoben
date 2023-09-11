package com.tao.test;

import org.sikuli.script.*;

public class SikuliExistsExample {
    public static void main(String[] args) {
        // 初始化 SikuliX
        Screen screen = new Screen();

        // 设置相似度阈值（可根据需要进行调整）

        try {
            Pattern pattern = new Pattern("/Users/taojinsheng/Pictures/dd.sikuli/test2.sikuli/1694396697494.png").similar(0.7); // 0.7 是相似度阈值

            // 使用exists方法查找图像，并传递 Pattern 对象
            Match match = screen.exists(pattern);

            if (match != null) {
                System.out.println("图像存在！");
            } else {
                System.out.println("图像不存在！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
