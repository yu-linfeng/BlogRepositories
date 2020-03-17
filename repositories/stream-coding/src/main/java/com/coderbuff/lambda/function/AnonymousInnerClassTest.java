package com.coderbuff.lambda.function;

/**
 * 按匿名类的方式使用一个函数式接口，传递行为
 * @author okevin
 * @date 2020/3/14 23:42
 */
public class AnonymousInnerClassTest {

    public static void main(String[] args) {
        AnonymousInnerClassTest anonymousInnerClassTest = new AnonymousInnerClassTest();

        anonymousInnerClassTest.testAnonymousInnerClass(x -> x > 1);
    }

    private void testAnonymousInnerClass(FunctionalInterfaceDemo functionalInterfaceDemo) {
        Integer number = 1;
        boolean result = functionalInterfaceDemo.test(number);
        System.out.println(result);
    }
}
