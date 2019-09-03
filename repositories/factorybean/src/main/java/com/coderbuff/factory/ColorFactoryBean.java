package com.coderbuff.factory;

import com.coderbuff.bean.Color;
import com.coderbuff.bean.Red;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author cdyulinfeng
 * @date 2019/9/3
 **/
public class ColorFactoryBean implements FactoryBean<Color> {

    public Color getObject() throws Exception {
        return new Red();
    }

    public Class<?> getObjectType() {
        return Red.class;
    }

    public boolean isSingleton() {
        return false;
    }
}
