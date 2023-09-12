package com.tao.factory;

import java.awt.*;
import java.util.Objects;

public class RobotFactory {

    private static Robot robot;

    public static Robot getRobot(){
        if(Objects.nonNull(robot)){
            return robot;
        }
        try {
            robot=new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return robot;
    }
}
