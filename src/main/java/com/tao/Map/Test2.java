package com.tao.Map;


import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class Test2 {

    public static void main(String[] args) throws TesseractException {
        System.setProperty("TESSDATA_PREFIX", "/usr/local/share/tessdata");
        System.setProperty("java.library.path", "/opt/local/lib/libtesseract.dylib");
        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("/usr/local/share/tessdata"); // 设置Tesseract的tessdata目录
        tesseract.setLanguage("eng"); // 设置要使用的语言，默认为英语
        File imageFile = new File("/Users/taojinsheng/Pictures/dumperror.png"); // 要识别的图像文件
        String result = tesseract.doOCR(imageFile); // 进行OCR识别
        System.out.println(result); // 输出识别结果
    }
}
