package com.tao.test;

import org.sikuli.script.*;

import java.awt.*;

public class Move {

    public static void main(String[] args) throws FindFailed, InterruptedException {
        GraphicsDevice[] screenDevices = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();

        // 初始化最大横坐标和纵坐标为0
        int maxWidth = 0;
        int maxHeight = 0;

        // 遍历所有屏幕设备
        for (GraphicsDevice screenDevice : screenDevices) {
            DisplayMode displayMode = screenDevice.getDisplayMode();

            // 获取每个屏幕设备的最大横坐标和纵坐标
            int width = displayMode.getWidth();
            int height = displayMode.getHeight();

            // 更新最大值
            if (width > maxWidth) {
                maxWidth = width;
            }

            if (height > maxHeight) {
                maxHeight = height;
            }
        }

        // 输出最大的横坐标和纵坐标
        System.out.println("最大横坐标：" + maxWidth);
        System.out.println("最大纵坐标：" + maxHeight);
        // 右击指定坐标
        int screenHeight = 1050; // 获取屏幕的最大纵坐标
        int adjustedY = screenHeight - 719; // 调整Y坐标
        Location targetLocation = new Location(986, adjustedY);
        targetLocation.rightClick();
        System.out.println("2222222222222");
        Thread.sleep(1000);
        Location targetLocation2 = new Location(970, adjustedY);
        targetLocation2.rightClick();


    }
}
