package com.tao.test;

import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

public class TextTest {

    public static void main(String[] args) {
        Pattern pattern=new Pattern("/Users/taojinsheng/Pictures/dd.sikuli/test2.sikuli/1694405780976.png");
        long currentTimeMillis = System.currentTimeMillis();
        Screen screen=new Screen();
        Match match = screen.exists(pattern);
        System.out.println(System.currentTimeMillis()-currentTimeMillis);
        match.click();

    }
}
