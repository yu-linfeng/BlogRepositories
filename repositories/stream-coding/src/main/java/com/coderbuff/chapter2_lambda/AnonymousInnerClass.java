package com.coderbuff.chapter2_lambda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 匿名内部类实现行为的传递
 * @author okevin
 * @date 2020/3/12
 */
public class AnonymousInnerClass {

    public void click() {
        Button button = new Button();

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("button clcked");
            }
        });
    }
}
