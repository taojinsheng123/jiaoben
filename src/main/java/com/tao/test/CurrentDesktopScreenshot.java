package com.tao.test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CurrentDesktopScreenshot {
    public static void main(String[] args) throws AWTException, IOException {
        int x = 100; // 左上角 x 坐标
        int y = 100; // 左上角 y 坐标
        int width = 500; // 截图宽度
        int height = 300; // 截图高度

        try {
            Robot robot = new Robot();
            Rectangle captureRect = new Rectangle(x, y, width, height);
            BufferedImage screenshot = robot.createScreenCapture(captureRect);

            File outputFile = new File("/Users/taojinsheng/Pictures/截图1.png");
            ImageIO.write(screenshot, "png", outputFile);

            System.out.println("Screenshot saved as screenshot.png");
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }
}
