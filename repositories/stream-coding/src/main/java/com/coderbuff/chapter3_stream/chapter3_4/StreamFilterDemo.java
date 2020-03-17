package com.coderbuff.chapter3_stream.chapter3_4;

import com.coderbuff.common.Student;
import com.coderbuff.common.StudentData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author okevin
 * @date 2020/3/17
 */
public class StreamFilterDemo {

    public static void main(String[] args) {
        List<Student> students = new StudentData().getStudentData();
        StreamFilterDemo streamFilterDemo = new StreamFilterDemo();
        List<Student> byFor = streamFilterDemo.fetchPassedStudentsByFor(students);
        byFor.forEach(System.out::println);
        System.out.println("---");
        List<Student> byStream = streamFilterDemo.fetchPassedStudentsByStreamFilter(students);
        byStream.forEach(System.out::println);
    }


    /**
     * 通过for循环筛选出分数大于60分的学生集合
     * @param students 待过滤的学生集合
     * @return 分数大于60分的学生集合
     */
    public List<Student> fetchPassedStudentsByFor(List<Student> students) {
        List<Student> passedStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getScore().compareTo(60.0) >= 0) {
                passedStudents.add(student);
            }
        }
        return passedStudents;
    }

    /**
     * 通过Stream filter筛选出分数大于60分的学生集合
     * @param students 待过滤的学生集合
     * @return 分数大于60分的学生集合
     */
    public List<Student> fetchPassedStudentsByStreamFilter(List<Student> students) {
        return students.stream()
                .filter(student -> student.getScore().compareTo(60.0) >= 0)
                .collect(Collectors.toList());
    }
}
