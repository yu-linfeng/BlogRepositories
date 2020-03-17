package com.coderbuff.lambda.function;

/**
 * 函数式接口
 * @FunctionalInterface 注解只是为了表明这是一个函数式接口，函数式接口只能包含一个方法。
 * @author okevin
 * @date 2020/3/14 23:32
 */
@FunctionalInterface
public interface FunctionalInterfaceDemo {
    boolean test(Integer x);
}
