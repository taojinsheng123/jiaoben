package com.tao.util;

import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyboardUtil {
    public static void main(String[] args) {
        suiji();
    }
    public static void suiji(){
        try {

            Robot robot = new Robot();

            // 模拟按下键盘上的数字键 "1"11111
            robot.keyPress(KeyEvent.VK_NUMPAD1);
            // 等待一会，可以根据需要调整时间（以毫秒为单位）
            Thread.sleep(500);
            // 松开按键
            robot.keyRelease(KeyEvent.VK_NUMPAD1);
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
