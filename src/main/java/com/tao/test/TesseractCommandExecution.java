package com.tao.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TesseractCommandExecution {
    public static void main(String[] args) {
        String imagePath = "/Users/taojinsheng/Pictures/dumperror.png"; // 图像文件的路径
        String tessPath = "/opt/local/bin/tesseract"; // tesseract命令的路径
        String output = "/Users/taojinsheng/output.txt"; // 输出文件名

        String[] command = { tessPath, imagePath, output };

        try {
            Process process = Runtime.getRuntime().exec("tesseract /Users/taojinsheng/Pictures/dumperror.png /Users/taojinsheng/output.txt -l eng");
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Command executed successfully.");
                // 读取并处理输出文件
            } else {
                System.out.println("Command failed with exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
