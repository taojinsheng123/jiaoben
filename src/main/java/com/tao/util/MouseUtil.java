package com.tao.util;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class MouseUtil {

    public static void clickZidong(Screen screen) {
        String rootPath = PathUtil.getRootPath();
        try {
            screen.click("/Users/taojinsheng/Downloads/code/jiaoben/src/main/resources/zidong.png");
        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }
}
