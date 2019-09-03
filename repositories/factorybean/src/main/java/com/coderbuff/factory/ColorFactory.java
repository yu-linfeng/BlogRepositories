package com.coderbuff.factory;

import com.coderbuff.bean.Color;
import com.coderbuff.bean.Red;

/**
 * 非静态工厂方法
 * @author cdyulinfeng
 * @date 2019/9/3
 **/
public class ColorFactory {

    public Color getInstance() {
        return new Red();
    }
}
