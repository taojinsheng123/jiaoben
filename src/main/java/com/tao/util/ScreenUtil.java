package com.tao.util;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.util.Objects;

public class ScreenUtil {

    public static Boolean click(Screen screen, String path, Double simliar) {
        try {
            Thread.sleep(400);
            path = ResourceUtil.getResourcesPath() + path;
            Pattern pattern = new Pattern(path);
            if (Objects.nonNull(simliar)) {
                pattern.similar(simliar);
            }
            screen.click(pattern);
            return true;
        } catch (Exception findFailed) {
            findFailed.printStackTrace();
        }
        return false;
    }
}
