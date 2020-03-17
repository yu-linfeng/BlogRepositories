package com.coderbuff.chapter3_stream.chapter3_4;

import com.coderbuff.common.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author okevin
 * @date 2020/3/17
 */
public class StreamMapDemo {

    /**
     * 通过for循环提取学生学号集合
     * @param list 学生对象集合
     * @return 学生学号集合
     */
    public List<Long> fetchStudentNumbersByFor(List<Student> list) {
        List<Long> numbers = new ArrayList<>();
        for (Student student : list) {
            numbers.add(student.getStudentNumber());
        }
        return numbers;
    }

    /**
     * 通过Stream map提取学生学号集合
     * @param list 学生对象集合
     * @return 学生学号集合
     */
    public List<Long> fetchStudentNumbersByStreamMap(List<Student> list) {
        return list.stream()
                   .map(Student::getStudentNumber)
                   .collect(Collectors.toList());
    }

    /**
     * 通过Stream map操作将小写的字符串集合转换为大写
     * @param list 小写字符串集合
     * @return 大写字符串集合
     */
    public List<String> toUpperByStreamMap(List<String> list) {
        return list.stream()
                   .map(String::toUpperCase)
                   .collect(Collectors.toList());
    }
}
