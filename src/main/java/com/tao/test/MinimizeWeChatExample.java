package com.tao.test;

import java.io.IOException;

public class MinimizeWeChatExample {
    public static void main(String[] args) {
        try {
            // 使用 AppleScript 执行最小化微信窗口的操作
            String script = "tell application \"System Events\" to tell process \"ApiPost7\" to set miniaturized of window 1 to true";
            String[] cmd = { "osascript", "-e", script };
            Process process = Runtime.getRuntime().exec(cmd);

            // 等待脚本执行完成
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("成功最小化微信窗口。");
            } else {
                System.err.println("无法最小化微信窗口。");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
