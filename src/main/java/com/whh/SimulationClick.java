package com.whh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

/**
 * @author whh
 * @mail <wanghuihai@lidig.com>
 * @date 2020/1/21
 */
public class SimulationClick extends JPanel implements KeyListener {

    public static void main(String[] args) throws AWTException, InterruptedException {
        SimulationClick simulationClick = new SimulationClick();

        Point point = MouseInfo.getPointerInfo().getLocation();
        System.out.println("当前的鼠标位置 x=" + point.getX() + ",y="
                + point.getY());
        while(true){
            Robot robot = new Robot();
            robot.mouseMove(706,127);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            //模拟鼠标松开左键
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            Thread.sleep(1000L);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * 按下键盘
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e)  {
        // 按下ctrl结束程序
        int keyCode = e.getKeyCode();
        if (keyCode == 17) {
            System.exit(1);
        }
        if (keyCode == 65) {
            Point point = MouseInfo.getPointerInfo().getLocation();
            System.out.println(String.format(" 当前的鼠标位置 x = %s, y = %s ", point.x, point.y));
        }
    }

    /**
     * 弹起
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        // 按下ctrl结束程序
        if (e.getKeyCode() == 17) {
            System.exit(1);
        }

    }
}
