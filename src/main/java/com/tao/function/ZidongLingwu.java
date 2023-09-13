package com.tao.function;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import java.io.File;

public class ZidongLingwu {
    public static void main(String[] args) throws InterruptedException {

        while (true) {
            Screen screen = new Screen();
            boolean s1= step1(screen);
            if(s1){
                boolean s2= step2(screen);
                if(s2){
                    boolean s3= step3(screen);
                    if(s3){
                        continue;
                    }
                }else {
                    continue;
                }
            }else {
                continue;
            }
        }

    }

    static boolean step1(Screen screen) {
        File file = new File("D:\\agamepic\\1");
        File[] files = file.listFiles();
        for (File file1 : files) {
            String absolutePath = file1.getAbsolutePath();
            try {
                Thread.sleep(1000);
                screen.click(absolutePath, (int) 0.5);
                Thread.sleep(1000);
                return true;
            } catch (FindFailed e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return false;
    }


    static boolean step2(Screen screen) {
        File file = new File("D:\\agamepic\\2");
        File[] files = file.listFiles();
        for (File file1 : files) {
            String absolutePath = file1.getAbsolutePath();
            try {
                Thread.sleep(10000);
                screen.click(absolutePath, (int) 0.5);
                Thread.sleep(1000);
                screen.click();
                return true;
            } catch (FindFailed e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    static boolean step3(Screen screen) {
        File file = new File("D:\\agamepic\\3");
        File[] files = file.listFiles();
        for (File file1 : files) {
            String absolutePath = file1.getAbsolutePath();
            try {
                Thread.sleep(2000);
                screen.click(absolutePath, (int) 0.5);
                Thread.sleep(1000);
                return true;
            } catch (FindFailed e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

}
