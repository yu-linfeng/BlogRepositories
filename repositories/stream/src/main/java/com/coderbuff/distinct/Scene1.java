package com.coderbuff.distinct;

import com.coderbuff.data.Student;
import com.coderbuff.data.StudentData;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 根据对象中的某个字段去重
 * @author yulinfeng
 * @date 2020/2/28
 */
public class Scene1 {

    /**
     * List列表中的元素是简单的数据类型
     */
    private void useSimpleDistinct() {
        List<String> repeat = new ArrayList<>();
        repeat.add("A");
        repeat.add("B");
        repeat.add("C");
        repeat.add("A");
        repeat.add("C");
        List<String> notRepeating = repeat.stream().distinct().collect(Collectors.toList());
        System.out.println("List列表中的元素是简单的数据类型：" + notRepeating.size());
        System.out.println("--------------");
    }


    public static void main(String[] args) {
        List<Student> students = new StudentData().getStudentData();
        System.out.println(students.stream().distinct().count());
        Scene1 scene1 = new Scene1();
        scene1.useSimpleDistinct();
        scene1.useStreamByTreeSet(students);
        scene1.useStreamByHashMap(students);
        scene1.useForByMap(students);

    }

    /**
     * List列表中的元素是对象类型，使用Stream利用HashMap通过对象中的学号字段去重，计算有多少学生
     * @param students 学生信息
     */
    private void useStreamByHashMap(List<Student> students) {
        long count = students.stream().map(Student::getStudentNumber).distinct().count();
        System.out.println("List列表中的元素是对象类型，使用Stream利用Map通过对象中的学号字段去重，计算有多少学生：" + count);
    }

    /**
     * List列表中的元素是对象类型，使用Stream利用TreeSet通过对象中的学号字段去重，计算有多少学生
     * @param students 重复学生数据
     */
    private void useStreamByTreeSet(List<Student> students) {
        int count = students.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Student::getStudentNumber))), ArrayList::new)).size();
        System.out.println("List列表中的元素是对象类型，使用Stream利用TreeSet通过对象中的学号字段去重，计算有多少学生：" + count);

    }


    /**
     * List列表中的元素是对象类型，使用For循环利用Map的key值不重复通过对象中的学号字段去重，计算有多少学生
     * @param students 学生信息
     */
    private void useForByMap(List<Student> students) {
        Map<Long, Student> map = new HashMap<>();
        for (Student student : students) {
            map.put(student.getStudentNumber(), student);
        }
        int count = map.keySet().size();
        System.out.println("List列表中的元素是对象类型，使用For循环利用Map的key值不重复通过对象中的学号字段去重，计算有多少学生：" + count);
    }
}
