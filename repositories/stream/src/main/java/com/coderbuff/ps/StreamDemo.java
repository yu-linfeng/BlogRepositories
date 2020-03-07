package com.coderbuff.ps;

import com.coderbuff.data.Student;
import com.coderbuff.data.StudentData;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author yulinfeng
 * @date 2020/3/4
 */
public class StreamDemo {

    public static void main(String[] args) {
        /*List<Student> students = new StudentData().getStudentData();
        Map<Long, List<Student>> studentMap = students.stream().collect(Collectors.groupingBy(Student::getStudentNumber)).entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(studentMap);
        StreamDemo streamDemo = new StreamDemo();
        streamDemo.useFor(students);
        streamDemo.useStream(students);*/

    }

    private void useFor(List<Student> students) {
        Map<Long, List<Student>> studentMap = new TreeMap<>();
        for (Student student : students) {
            studentMap.computeIfAbsent(student.getStudentNumber(), studentNumber -> new ArrayList<>()).add(student);
        }
        System.out.println("使用for+TreeMap对Key键分组并排序：" + studentMap);
    }

    private void useStream(List<Student> students) {
        Map<Long, List<Student>> studentMap = students.stream().collect(Collectors.groupingBy(Student::getStudentNumber));
        Map<Long, List<Student>> sortedStudentMap = new TreeMap<>(studentMap);
        System.out.println("使用Stream对Key键分组并排序：" + sortedStudentMap);
    }
}
