package com.tao.Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Test3 {
    public static void main(String[] args) {
        String imagePath = "/Users/taojinsheng/Pictures/dumperror.png"; // 替换为您的图像文件路径
        String tesseractPath = "/opt/local/bin/tesseract"; // 替换为您的Tesseract可执行文件路径
        String libraryPath = "/opt/local/lib/libtesseract.dylib"; // Tesseract库文件所在的路径
        String outputFilePath = "/Users/taojinsheng/output.txt"; // 输出文件路径

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(
                    tesseractPath,
                    imagePath,
                    outputFilePath
            );

            // 设置库路径
            processBuilder.environment().put("DYLD_LIBRARY_PATH", libraryPath);

            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("Text extracted successfully.");
                // 读取输出文件中的识别文本
                String recognizedText = readOutputFile(outputFilePath);
                System.out.println("Recognized Text:\n" + recognizedText);
            } else {
                System.err.println("Error during text extraction.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String readOutputFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (InputStream inputStream = Test3.class.getResourceAsStream(filePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }
}
