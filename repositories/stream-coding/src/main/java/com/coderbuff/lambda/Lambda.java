package com.coderbuff.lambda;

import java.awt.*;

/**
 * lambda表达式实现行为的传递
 * @author okevin
 * @date 2020/3/12
 */
public class Lambda {

    public void click() {
        Button button = new Button();

        button.addActionListener(event -> System.out.println("button clicked"));
    }
}
