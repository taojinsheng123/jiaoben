package com.tao.function;

import com.tao.mouse.Mouse;
import com.tao.util.ResourceUtil;
import com.tao.util.ScreenUtil;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import java.time.LocalDateTime;

public class ShouquBaoxiangFunction {

    private LocalDateTime fabao1LingquTime = LocalDateTime.now();


    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(3000);
        ShouquBaoxiangFunction shouquBaoxiangFunction=new ShouquBaoxiangFunction();
        shouquBaoxiangFunction.moveToBaoxiangChuanSongAndMove();

    }
    public void getBaoxiang() {
        while (fabao1LingquTime.plusHours(12).isAfter(LocalDateTime.now())) {
            huicheng();
            moveToBaoxiangChuanSongAndMove();
            moveToBaoxiangNpc1AndGet();
            moveToBaoxiangNpc2AndGet();
            moveToBaoxiangNpc3AndGet();
        }
    }

    private void huicheng() {
        try {

        }catch (Exception e){

        }
        //按下按键2 按键2配置回程

    }

    private void moveToBaoxiangChuanSongAndMove() {
        Mouse.moveToNpc(329,327,321,337);
        Screen screen=new Screen();
        ScreenUtil.click(screen,"map/tucheng/wkchuansong.png",0.6);
        ScreenUtil.click(screen,"map/tucheng/juxiantai.png",0.6);

    }

    private void moveToBaoxiangNpc1AndGet() {

    }

    private void moveToBaoxiangNpc2AndGet() {

    }

    private void moveToBaoxiangNpc3AndGet() {

    }

}
