package com.tao.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class MoveMouseInGame {
    public static void main(String[] args) {
        try {
            Robot robot = new Robot();
            // 假设游戏中A和B的坐标
            int x1 = 100; // A点的x坐标
            int y1 = 200; // A点的y坐标
            int x2 = 300; // B点的x坐标
            int y2 = 400; // B点的y坐标

            // 假设游戏窗口的坐标和大小
            int gameWindowX = 50;
            int gameWindowY = 50;
            int gameWindowWidth = 800;
            int gameWindowHeight = 600;

            // 计算A和B在游戏窗口内的坐标
            int gameX1 = x1 - gameWindowX;
            int gameY1 = y1 - gameWindowY;
            int gameX2 = x2 - gameWindowX;
            int gameY2 = y2 - gameWindowY;

            // 移动鼠标到A点
            robot.mouseMove(gameX1, gameY1);

            // 模拟右击操作
            robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

            // 移动鼠标到B点
            robot.mouseMove(gameX2, gameY2);

            // 模拟右击操作
            robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
