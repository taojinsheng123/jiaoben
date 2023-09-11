package com.tao.test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ColorDetectionExample {
    public static void main(String[] args) throws AWTException, IOException {
        Robot robot = new Robot();

        // 定义目标颜色
        Color targetColor = new Color(6, 33, 29); // 例如：RGB (6, 125, 123)

        // 获取屏幕尺寸
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        // 获取屏幕截图
        BufferedImage screenImage = robot.createScreenCapture(screenRect);
        File outputFile = new File("/Users/taojinsheng/fullscreen.png");

        // 将屏幕截图保存为图像文件
        ImageIO.write(screenImage, "png", outputFile);
        // 遍历屏幕像素
        for (int x = 0; x < screenRect.width; x++) {
            for (int y = 0; y < screenRect.height; y++) {
                // 获取像素颜色
                Color pixelColor = new Color(screenImage.getRGB(x, y));
                //System.out.println(pixelColor);
                // 检查是否匹配目标颜色
                if (pixelColor.equals(targetColor)) {
                    System.out.println("找到匹配颜色于坐标 X: " + x + " Y: " + y);
                    // 在这里可以执行点击等操作
                }
            }
        }
    }
}
