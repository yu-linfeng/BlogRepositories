package com.coderbuff.factory;

import com.coderbuff.bean.Color;
import com.coderbuff.bean.Red;

/**
 * 静态工厂方法
 * @author cdyulinfeng
 * @date 2019/9/3
 **/
public class StaticColorFactory {


    /**
     * 静态工厂方法
     * @return 颜色
     */
    public static Color getInstance() {
        return new Red();
    }
}
