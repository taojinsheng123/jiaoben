package com.tao.mouse;

import com.tao.factory.RobotFactory;
import org.sikuli.script.Screen;

import java.awt.*;
import java.awt.event.InputEvent;

public class Mouse {

    private static int centerX;
    private static int centerY;

    static {

        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("win")) {
            System.out.println("当前操作系统是 Windows");
            //计算人物坐标
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            // 计算屏幕中心坐标
            centerX = screenSize.width / 2;
            centerY = screenSize.height / 2;
            Screen screen = new Screen();
            screen.mouseMove(centerX, centerY);
        } else if (osName.contains("mac")) {
            try {
                // 获取屏幕的尺寸
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

                // 计算屏幕中心坐标
                centerX = screenSize.width / 2;
                centerY = screenSize.height / 2;

                // 创建Robot对象
                Robot robot = new Robot();

                // 移动鼠标到中心坐标
                robot.mouseMove(centerX, centerY);
                Thread.sleep(400);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("当前操作系统是 macOS");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(1);

        System.out.println(Math.abs(-2));
        /*moveCharacterUp(RobotFactory.getRobot());
        Thread.sleep(400);
        moveCharacterLeftUp(RobotFactory.getRobot());
        Thread.sleep(400);
        moveCharacterLeft(RobotFactory.getRobot());
        Thread.sleep(400);
        moveCharacterLeftDown(RobotFactory.getRobot());
        Thread.sleep(400);
        moveCharacterDown(RobotFactory.getRobot());
        Thread.sleep(400);
        moveCharacterRightDown(RobotFactory.getRobot());
        Thread.sleep(400);
        moveCharacterRight(RobotFactory.getRobot());
        Thread.sleep(400);
        moveCharacterRightUp(RobotFactory.getRobot());*/
    }

    public static void moveCharacterLeftUp(Robot robot) {
        // 实现角色向左上方移动的逻辑
        robot.mouseMove(centerX - 200, centerY - 200);
    }

    public static void moveCharacterRightUp(Robot robot) {
        // 实现角色向右上方移动的逻辑
        robot.mouseMove(centerX + 200, centerY - 200);
    }

    public static void moveCharacterLeftDown(Robot robot) {
        // 实现角色向左下方移动的逻辑
        robot.mouseMove(centerX - 200, centerY + 200);
    }

    public static void moveCharacterRightDown(Robot robot) {
        // 实现角色向右下方移动的逻辑
        robot.mouseMove(centerX + 200, centerY + 200);
    }

    public static void moveCharacterLeft(Robot robot) {
        // 实现角色向左移动的逻辑
        robot.mouseMove(centerX - 200, centerY);
    }

    public static void moveCharacterRight(Robot robot) {
        // 实现角色向右移动的逻辑
        robot.mouseMove(centerX + 200, centerY);
    }

    public static void moveCharacterUp(Robot robot) {
        // 实现角色向上移动的逻辑
        robot.mouseMove(centerX, centerY - 200);
    }

    public static void moveCharacterDown(Robot robot) {
        // 实现角色向下移动的逻辑
        robot.mouseMove(centerX, centerY + 200);
    }


    public static void moveToNpc(int x, int y, int targetX, int targetY) {
        try {
            // 计算水平距离（x方向上的差值）
            int horizontalDistance = (targetX - x) / 2;
            // 计算垂直距离（y方向上的差值）
            int verticalDistance = (targetY - y) / 2;
            Robot robot = RobotFactory.getRobot();
            if (horizontalDistance > 0) {
                moveCharacterRight(robot);
            } else {
                moveCharacterLeft(robot);
            }
            for (int distance = Math.abs(horizontalDistance); distance > 0; distance--) {
                Thread.sleep(300);
                robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                // 模拟鼠标右键释放操作
                Thread.sleep(300);
                robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
            }
            if (verticalDistance > 0) {
                moveCharacterDown(robot);
            } else {
                moveCharacterUp(robot);
            }
            for (int distance = Math.abs(verticalDistance); distance > 0; distance--) {
                Thread.sleep(300);
                robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                // 模拟鼠标右键释放操作
                Thread.sleep(300);
                robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
            }
        } catch (Exception e) {
            System.out.println("移动npc错误");
        }
    }
}
