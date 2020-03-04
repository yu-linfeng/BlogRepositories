package com.coderbuff.filter;

import com.coderbuff.data.Student;
import com.coderbuff.data.StudentData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 场景一：过滤掉分数低于70分的数据
 * @author yulinfeng
 * @date 2020/3/3
 */
public class Scene1 {

    public static void main(String[] args) {
        List<Student> students = new StudentData().getStudentData();
        Scene1 scene1 = new Scene1();
        List<Student> studentsByFor = scene1.useFor(students);
        scene1.printList(studentsByFor);

        List<Student> studentsByStream = scene1.useStream(students);
        scene1.printList(studentsByStream);

    }

    /**
     * 通过for循环过滤
     * @param  students 学生数据
     * @return 过滤后的学生数据
     */
    public List<Student> useFor(List<Student> students) {
        List<Student> filterStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getScore().compareTo(70.0) > 0) {
                filterStudents.add(student);
            }
        }
        return filterStudents;
    }

    /**
     * 通过Stream的filter过滤操作
     * @param students 学生数据
     * @return 过滤后的学生数据
     */
    public List<Student> useStream(List<Student> students) {
        List<Student> filter = students.stream().filter(student -> student.getScore().compareTo(70.0) > 0).collect(Collectors.toList());
        return filter;
    }

    public void printList(List<Student> students) {
        students.stream().forEach(student -> System.out.println(student));
    }
}
