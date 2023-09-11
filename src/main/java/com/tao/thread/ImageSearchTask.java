package com.tao.thread;

import org.sikuli.script.*;

import java.util.concurrent.Callable;

public class ImageSearchTask implements Callable<Boolean> {
    private Screen screen;
    private Pattern pattern;
    private Region region;

    public ImageSearchTask(Screen screen, Pattern pattern, Region region) {
        this.screen = screen;
        this.pattern = pattern;
        this.region = region;
    }

    @Override
    public Boolean call() {
        // 使用 exists 方法查找图像，并传递 Pattern 对象
        long currentTimeMillis = System.currentTimeMillis();
        Match match = screen.exists(pattern);
        System.out.println("识别一样图耗时："+(System.currentTimeMillis()-currentTimeMillis));
        return match != null;
    }
}
