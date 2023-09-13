package com.tao.function;

import com.tao.util.DeskTopUtil;
import com.tao.util.ResourceUtil;
import com.tao.util.ScreenUtil;
import org.sikuli.script.Screen;

public class CheckGuajiStatus extends Thread{

    public static void main(String[] args) throws InterruptedException {
        CheckGuajiStatus s=new CheckGuajiStatus();
        new Thread(()-> {
            try {
                s.doJob1("common/hao1.png");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                s.doJob1("common/hao2.png");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    public synchronized void doJob1(String path) throws InterruptedException {
        while (true){Thread.sleep(3000);
            System.out.println("dojob:"+path);
            DeskTopUtil.backtoDeskTop();
            Screen screen=new Screen();
            Boolean click = ScreenUtil.click(screen, path, 0.8);
            if(click){
                Thread.sleep(1000);
                Boolean click2 = ScreenUtil.click(screen, "common/zidong.png", 0.7);
                if(click2){
                    notify();
                    System.out.println("dojob:"+path+"wait");
                    wait(100000);
                }
            }
            notify();
            System.out.println("dojob:"+path+"wait");
            wait(100000);
        }
    }
}
