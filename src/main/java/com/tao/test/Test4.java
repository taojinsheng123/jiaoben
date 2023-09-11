package com.tao.test;

import org.sikuli.script.*;

import java.awt.*;


public class Test4 {
    public static void main(String[] args) {
        Screen screen = new Screen();
        ScreenImage screenshot = screen.capture();

        // 保存截图到指定文件路径
        screenshot.save("/Users/taojinsheng");
        System.out.println("屏幕截图已保存为 screenshot.png");
        // 定义识别区域和NPC颜色特征
        Color targetColor = new Color(6, 125, 123); // NPC的颜色
        //Color targetColor2 = new Color(164, 37, 36); // NPC的颜色
        //Color targetColor3 = new Color(153, 37, 47); // NPC的颜色
        Pattern colorPattern = new Pattern(String.valueOf(targetColor));
        try {
            // 在识别区域内查找NPC颜色
            Match match = screen.find(colorPattern);
            //Match match2 = screen.find(targetColor2);
            //Match match3 = screen.find(targetColor3);
            // 如果找到了匹配颜色
            if (match != null ) {
                // 计算点击坐标
                int clickX = match.x + match.w / 2;
                int clickY = match.y + match.h / 2;

                // 执行点击操作
                screen.click(clickX, clickY);
            } else {
                System.out.println("未找到NPC");
            }
        } catch (FindFailed e) {
            e.printStackTrace();
        }
    }
}
