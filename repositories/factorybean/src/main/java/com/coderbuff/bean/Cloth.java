package com.coderbuff.bean;

/**
 * 布料
 * 包含颜色属性
 * Created by OKevin On 2019/9/3
 **/
public class Cloth {

    /**
     * 需要通过ColorFactory或StaticColorFactory注入具体的颜色
     */
    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
