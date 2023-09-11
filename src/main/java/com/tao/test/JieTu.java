package com.tao.test;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class JieTu{
    private String fileName; //文件的前缀
    private String defaultName = "GuiCamera";
    static int serialNum=0;
    private String imageFormat; //图像文件的格式
    private String defaultImageFormat="png";
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    private int ax = 0;
    private int ay = 0;
    private int bx = 0;
    private int by = 0;

    public JieTu() {
        this.fileName = defaultName;
        this.imageFormat=defaultImageFormat;

    }

    public JieTu(String s,String format) {
        this.fileName = s;
        this.imageFormat=format;
    }

    public JieTu(String s,String format,int ax, int ay, int bx, int by) {
        this.ax = ax;
        this.ay = ay;
        this.bx = bx;
        this.by = by;
        this.fileName = s;
        this.imageFormat=format;
    }

    /****************************************************************
     * 对屏幕进行拍照
     * snapShot the Gui once
     ****************************************************************/
    public void snapShot() {
        try {
            //拷贝屏幕到一个BufferedImage对象screenshot
//            int x = (int) d.getWidth();//屏幕宽;
//            int y = (int) d.getHeight();//屏幕高
            BufferedImage screenshot = (new Robot()).createScreenCapture(new
                    Rectangle(ax, ay, bx-ax, by-ay));
            serialNum++;
            //根据文件前缀变量和文件格式变量，自动生成文件名
            String name=fileName+String.valueOf(serialNum)+"."+imageFormat;
            File f = new File(name);
            if(f.exists()){
                f.delete();
            }
            System.out.print("Save File "+name);
            //将screenshot对象写入图像文件
            ImageIO.write(screenshot, imageFormat, f);
            System.out.print("..Finished!\n");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args){
        //Thread.sleep(5000);
        JieTu cam= new JieTu("d:\\Hello", "png", 0, 0, 600, 800);//
        cam.snapShot();

    }
}