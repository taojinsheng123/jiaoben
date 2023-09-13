package com.tao.test;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;

public class Test {
    public static void main(String[] args) {
        User32 user32 = User32.INSTANCE;

        // 使用 FindWindow 函数查找游戏窗口
        WinDef.HWND hwnd = user32.FindWindow(null, "藏龙01区(通宵区)");

        if (hwnd != null) {
            // 使用 GetWindowRect 函数获取窗口位置和大小
            WinDef.RECT rect = new WinDef.RECT();
            user32.GetWindowRect(hwnd, rect);

            int windowX = rect.left;
            int windowY = rect.top;

            System.out.println("窗口位置 X: " + windowX + ", Y: " + windowY);
        } else {
            System.out.println("未找到游戏窗口");
        }
    }
}
