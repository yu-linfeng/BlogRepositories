package com.coderbuff.tips;

import com.coderbuff.data.Student;
import com.coderbuff.data.StudentData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yulinfeng
 * @date 2020/3/3
 */
public class Tips {
    public static void main(String[] args) {
        List<Student> students = new StudentData().getStudentData();
        Tips tips = new Tips();
       // tips.stringDelimiterSimple();
        //tips.intDelimiterSimple();
        tips.delimiter(students);
    }

    /**
     * 将List<String>类型转换为以"，"分割的字符串
     */
    private void stringDelimiterSimple() {
        List<String> names = new ArrayList();
        names.add("kevin");
        names.add("coderbuff");
        names.add("coderbook");
        String str = names.stream().collect(Collectors.joining(","));
        //String str = String.join(",", names);       也可以直接使用JDK8对字符串提供的新方法
        System.out.println(str);
    }

    /**
     * 将List<Integer>类型转换拿为"，"分割的字符串
     * 需要在操作流的时候先将Integer -> String，才能使用Collectors.joining方法
     */
    private void intDelimiterSimple() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        String str = ids.stream().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(str);
    }

    /**
     * 将List<Student>类型中的学号字段转换为"，"分割的字符串
     * @param students 学生信息
     */
    private void delimiter(List<Student> students) {
        String studentNumbers = students.stream().map(Student::getStudentNumber).distinct().map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(studentNumbers);
    }
}
