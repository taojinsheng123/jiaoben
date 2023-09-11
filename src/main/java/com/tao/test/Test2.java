package com.tao.test;

import org.sikuli.script.*;

public class Test2 {
    public static void main(String[] args) throws FindFailed, InterruptedException {
        Screen screen = new Screen();
        Pattern pattern = new Pattern("/Users/taojinsheng/Pictures/dd.sikuli/test2.sikuli/1694137938478.png").similar(0.7f);
        Match match = screen.exists(pattern);
        if (match != null) {
            System.out.println("找到匹配的图像");
            Thread.sleep(200);
            screen.click(match);
            Thread.sleep(500);
            match.rightClick();
        } else {
            System.out.println("未找到匹配的图像");
        }
        Thread.sleep(500);
        Pattern pattern2 = new Pattern("/Users/taojinsheng/Pictures/dd.sikuli/test2.sikuli/1694138458252.png").similar(0.7f);
        Match match2 = screen.wait(pattern2);
        if (match2 != null) {
            System.out.println("找到匹配的图像2");
            screen.click(match2);
        } else {
            System.out.println("未找到匹配的图像");
        }
        Thread.sleep(500);
        Pattern pattern3 = new Pattern("/Users/taojinsheng/Pictures/dd.sikuli/test2.sikuli/1694138518593.png").similar(0.7f);
        Match match3 = screen.wait(pattern3);
        if (match3 != null) {
            screen.click(match3);
            System.out.println("找到匹配的图像3");
        } else {
            System.out.println("未找到匹配的图像");
        }
    }
}
