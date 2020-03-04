package com.coderbuff.group;

import com.coderbuff.data.Student;
import com.coderbuff.data.StudentData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 场景一：通过学号对学生进行分组，例如：Map<Long, List<Student>>，key=学号，value=学生成绩信息
 * @author yulinfeng
 * @date 2020/3/3
 */
public class Scene1 {
    public static void main(String[] args) {
        List<Student> students = new StudentData().getStudentData();
        Scene1 scene1 = new Scene1();
        Map<Long, List<Student>> mapByFor = scene1.useFor(students);
        scene1.printMap(mapByFor);
        Map<Long, List<Student>> mapByStream = scene1.useStream(students);
        scene1.printMap(mapByStream);
        Map<Long, List<Student>> mapByStreamGroup = scene1.useStreamByGroup(students);
        scene1.printMap(mapByStreamGroup);
    }

    /**
     * 将List转换为Map，其中value是简单数据结构
     * @param students 学生信息
     */
    private void useSimpleStream(List<Student> students) {
        Map<Long, String> studentNameMap = students.stream().collect(Collectors.toMap(Student::getStudentNumber, Student::getStudentName));
        Map<Long, Student> studentMap = students.stream().collect(Collectors.toMap(Student::getStudentNumber, student -> student));
    }

    /**
     * 通过Group分组操作
     * @param students 学生信息
     * @return 学生信息，key=学号，value=学生信息
     */
    private Map<Long, List<Student>> useStreamByGroup(List<Student> students) {
        Map<Long, List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getStudentNumber));
        return map;
    }

    private Map<Long, List<Student>> useStream(List<Student> students) {
        Map<Long, List<Student>> map = students.stream().collect(Collectors.toMap(Student::getStudentNumber, student -> {
                    List<Student> getStudentList = new ArrayList<>();
                    getStudentList.add(student);
                    return getStudentList;
                },
                (List<Student> students1, List<Student> students2) -> {
                    students1.addAll(students2);
                    return students1;
                }
        ));


        return map;
    }

    /**
     * 借助Map通过for循环分类
     * @param students 学生信息
     */
    private Map<Long, List<Student>> useFor(List<Student> students) {
        Map<Long, List<Student>> map = new HashMap<>();
        for (Student student : students) {
            List<Student> list = map.get(student.getStudentNumber());
            if (list == null) {
                list = new ArrayList<>();
                map.put(student.getStudentNumber(), list);
            }
            list.add(student);
        }
        return map;
    }

    private void printMap(Map<Long, List<Student>> studentMap) {
        for (Map.Entry<Long, List<Student>> entry : studentMap.entrySet()) {
            System.out.println("学号：" + entry.getKey());
            for (Student student : entry.getValue()) {
                System.out.println("\t信息：" + student.getStudentName() + " " + student.getCourse() + " " + student.getScore());
            }
        }
    }
}
