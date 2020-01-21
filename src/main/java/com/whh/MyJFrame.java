package com.whh;

import javax.swing.*;
import java.awt.*;

/**
 * @author whh
 * @mail <wanghuihai@lidig.com>
 * @date 2020/1/21
 */
public class MyJFrame extends JFrame {
    public static void main(String[] args) throws InterruptedException {
        MyJFrame myJFrame = new MyJFrame();
        Thread.sleep(5600000L);
    }

    public MyJFrame() throws HeadlessException {
        SimulationClick simulationClick = new SimulationClick();
        add(simulationClick);
        addKeyListener(simulationClick);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
