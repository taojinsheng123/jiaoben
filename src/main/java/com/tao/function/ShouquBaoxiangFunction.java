package com.tao.function;

import java.time.LocalDateTime;

public class ShouquBaoxiangFunction {

    private LocalDateTime fabao1LingquTime = LocalDateTime.now();


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

    }

    private void moveToBaoxiangNpc1AndGet() {

    }

    private void moveToBaoxiangNpc2AndGet() {

    }

    private void moveToBaoxiangNpc3AndGet() {

    }

}
