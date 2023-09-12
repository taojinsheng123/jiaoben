import java.awt.*;

public class Pingmuzhongxinzuobiao {
    public static void main(String[] args) {
            // 获取屏幕的尺寸
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

            // 计算屏幕中心坐标
            int centerX = screenSize.width / 2;
            int centerY = screenSize.height / 2;

            // 打印屏幕中心坐标
            System.out.println("屏幕中心坐标：(" + centerX + ", " + centerY + ")");
        }
}
