package com.tao.Map;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenCapture {
    public static void main(String[] args) {
        try {

            Robot robot = new Robot();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle screenRectangle = new Rectangle(screenSize);

            BufferedImage screenshot = robot.createScreenCapture(screenRectangle);

            File output = new File("/Users/taojinsheng/Pictures/scre2enshot.png");
            ImageIO.write(screenshot, "png", output);

            System.out.println("Screenshot saved to: " + output.getAbsolutePath());
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }
}
