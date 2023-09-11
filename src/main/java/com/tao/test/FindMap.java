package com.tao.test;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class FindMap {
    public static void main(String[] args) throws InterruptedException, FindFailed {
        Screen screen = new Screen();
        Pattern pattern = new Pattern("/Users/taojinsheng/Pictures/dd.sikuli/test2.sikuli/1694141604753.png").similar(0.7f);
        Match match = screen.wait(pattern);
        if (match != null) {
            System.out.println("找到匹配的图像");
            Thread.sleep(200);
            screen.click(match);
        } else {
            System.out.println("未找到匹配的图像");
        }
    }
}
