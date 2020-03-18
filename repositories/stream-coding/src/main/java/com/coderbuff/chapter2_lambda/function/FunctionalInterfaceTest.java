package com.coderbuff.chapter2_lambda.function;

/**
 * @author okevin
 * @date 2020/3/14 23:34
 */
public class FunctionalInterfaceTest {
    public static void main(String[] args) {
        FunctionalInterfaceTest test = new FunctionalInterfaceTest();
        test.number(number -> true);
    }

    private boolean number(FunctionalInterfaceDemo functionalInterfaceDemo) {
        //functionalInterfaceDemo.test()
        return false;
    }
}
