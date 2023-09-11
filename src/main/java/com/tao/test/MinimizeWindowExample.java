package com.tao.test;

import java.io.IOException;

class MinimizeActiveWindowOnMac {
    public static void main(String[] args) {
        try {
            // 使用Runtime执行AppleScript命令
            String[] command = { "osascript", "-e", "tell application \"System Events\" to keystroke \"m\" using command down" };
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
