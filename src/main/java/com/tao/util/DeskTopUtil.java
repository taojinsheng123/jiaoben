package com.tao.util;

import java.awt.*;
import java.awt.event.KeyEvent;

public class DeskTopUtil {

    public static void main(String[] args) {
        backtoDeskTop();
        
    }
    public static void  backtoDeskTop(){
        try {
            Robot robot = new Robot();

            // 模拟按下并释放'Windows'键
            robot.keyPress(KeyEvent.VK_WINDOWS);
            robot.keyPress(KeyEvent.VK_D);
            robot.keyRelease(KeyEvent.VK_WINDOWS);
            // 模拟按下并释放'D'键
            robot.keyRelease(KeyEvent.VK_D);

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
