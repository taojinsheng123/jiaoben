package com.tao.test;


import org.sikuli.script.*;

public class SikuliExample {
    public static void main(String[] args) {
        // 创建一个屏幕对象
        Screen screen = new Screen();

        try {
            // 在屏幕上查找数字“123”并返回匹配对象
            Match match = screen.find("123.png");

            if (match != null) {
                // 找到数字，输出坐标
                int x = match.getX();
                int y = match.getY();
                System.out.println("数字“123”的坐标：X=" + x + ", Y=" + y);
            } else {
                System.out.println("未找到数字“123”。");
            }
        } catch (FindFailed e) {
            e.printStackTrace();
        }
    }
}
