package com.whh;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Scanner;

/**
 * @author whh
 * @mail <wanghuihai@lidig.com>
 * @date 2020/1/21
 */
public class App {
    public static void main(String[] args) throws InterruptedException, AWTException {
        Scanner scanner = new Scanner(System.in);
        int x1 = 0;
        int x2 = 0;
        int y1 = 0;
        int y2 = 0;
        int count = 1000;
        Long time = 1000L;
        Robot robot = new Robot();
        while(true){
            System.out.println("请输入值: \r\n " +
                    "0 = 记录当前鼠标位置(奇数执行) \r\n " +
                    "1 = 记录当前鼠标位置(偶数执行)\r\n " +
                    "2 = 执行次数\r\n " +
                    "3 = 间隔时间(分钟)\r\n " +
                    "4 = 开始执行(默认1000次 间隔时间1秒 坐标= 0,0) \r\n " +
                    "5 = 结束程序");
            int info = scanner.nextInt();
            switch (info) {
                // 获取当前坐标
                case 0 :
                    Point location = MouseInfo.getPointerInfo().getLocation();
                    x2 = location.x;
                    y2 = location.y;
                    System.out.println(String.format("x = %s, y= %s", x2, y2));
                    break;
                // 获取当前坐标
                case 1 :
                    location = MouseInfo.getPointerInfo().getLocation();
                    x1 = location.x;
                    y1 = location.y;
                    System.out.println(String.format("x = %s, y= %s", x1, y1));
                    break;
                // 输入执行次数
                case 2 :
                    System.out.println("请输入执行次数:");
                    count = scanner.nextInt();
                    System.out.println(String.format("执行次数 = %s", count));
                    // 输入间隔时间
                    break;
                case 3 :
                    System.out.println("请输入间隔时间:");
                    time = scanner.nextLong() * 60 * 1000;
                    System.out.println(String.format("间隔时间 = %s", time));
                    break;
                // 开始执行程序
                case 4 :
                    for (int i = 0; i < 1000000; i++) {
                        if (i % 2 == 0) {
//                            x = 1141, y= 340
                            // 移动坐标轴
                            robot.mouseMove(x1,y1);
                        } else {
//                            x = 1243, y= 548
                            // 移动坐标轴
                            robot.mouseMove(x2,y2);
                        }
                        // 按下
                        robot.mousePress(InputEvent.BUTTON1_MASK);
                        // 弹起
                        robot.mouseRelease(InputEvent.BUTTON1_MASK);
                        // 等待时间
                        Thread.sleep(time);
                    }
                case 5 :
                    System.out.println("程序结束");
                    System.exit(1);
                    break;
            }
        }
    }
}
