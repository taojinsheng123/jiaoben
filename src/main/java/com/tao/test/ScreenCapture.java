package com.tao.test;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class ScreenCapture extends JFrame implements ActionListener {
    private JButton captureButton;
    private JLabel statusLabel;
    private Robot robot;

    public ScreenCapture() {
        super("Screen Capture");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        captureButton = new JButton("Capture");
        captureButton.addActionListener(this);
        add(captureButton);

        statusLabel = new JLabel(" ");
        add(statusLabel);

        try {
            robot = new Robot();
        } catch (AWTException e) {
            statusLabel.setText("Error: " + e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == captureButton) {
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenCapture = robot.createScreenCapture(screenRect);
            ImageIcon icon = new ImageIcon(screenCapture);
            statusLabel.setIcon(icon);
            statusLabel.setText("Screenshot captured.");
            captureButton.setText("Click");
            captureButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Point clickPoint = ((JButton)e.getSource()).getLocationOnScreen();
                    clickPoint.x += ((JButton)e.getSource()).getWidth() / 2;
                    clickPoint.y += ((JButton)e.getSource()).getHeight() / 2;
                    robot.mouseMove(clickPoint.x, clickPoint.y);
                    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    statusLabel.setText("Text clicked.");
                }
            });
        }
    }

    public static void main(String[] args) {
        new ScreenCapture();
    }
}