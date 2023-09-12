package com.tao.test;

import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import java.awt.*;

public class TextTest {

    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // 获取当前窗口
        Window window = new Window(null); // 指定null参数表示获取当前窗口

        // 获取窗口的位置和大小
        Point windowLocation = window.getLocation();
        Dimension windowSize = window.getSize();

        System.out.println("窗口位置：" + windowLocation);
        System.out.println("窗口大小：" + windowSize);

    }
}
