package com.tao.function;

import com.tao.thread.ImageSearchTask;
import com.tao.util.KeyboardUtil;
import com.tao.util.MouseUtil;
import lombok.extern.slf4j.Slf4j;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class WuguaiSuiji {

    ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        WuguaiSuiji w = new WuguaiSuiji();
        w.dojob();
    }

    public void dojob() {
        while (true) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                Screen screen = new Screen();
                Region region = new Region(100, 100, 100, 100);
                if (!haveMaster(screen,region)) {
                    //log.info("当前无怪");
                    KeyboardUtil.suiji();
                    System.out.println("按下随机");
                    MouseUtil.clickZidong(screen);
                    System.out.println("waitjiehsu");
                    System.out.println("耗时：" + (System.currentTimeMillis() - currentTimeMillis));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean haveMaster(Screen screen,Region region) {
        //
        long currentTimeMillis = System.currentTimeMillis();
        int numThreads = Runtime.getRuntime().availableProcessors(); // 使用可用处理器数目作为线程数
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        String path = "/Users/taojinsheng/Downloads/code/jiaoben/src/main/resources/map.zuma.monster";
        File dir = new File(path);
        File[] files = dir.listFiles();
        List<Callable<Boolean>> tasks = new ArrayList<>();
        try {
            for (File file : files) {
                Pattern pattern = new Pattern(file.getAbsolutePath()).similar(0.7); // 0.7 是相似度阈值
                tasks.add(new ImageSearchTask(screen, pattern,region));
            }
            List<Future<Boolean>> results = executorService.invokeAll(tasks);
            // 检查每个任务的结果
            for (Future<Boolean> result : results) {
                if (result.get()) {
                    System.out.println("图像存在！");
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("解析图耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        return false;
    }


}
