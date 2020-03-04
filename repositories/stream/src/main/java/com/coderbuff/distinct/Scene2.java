package com.coderbuff.distinct;

import com.coderbuff.data.Student;
import com.coderbuff.data.StudentData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 场景二：通过学号+姓名去重，一共有多少学生
 * @author yulinfeng
 * @date 2020/3/3
 */
public class Scene2 {
    public static void main(String[] args) {
        List<Student> students = new StudentData().getStudentData();
        Scene2 scene2 = new Scene2();
        scene2.useForByMap(students);
        scene2.useStreamByHashMap(students);
    }

    /**
     * List列表中的元素是对象类型，使用For循环利用Map的key值不重复通过对象中的学号+姓名字段去重，计算有多少学生
     * @param students 学生信息
     */
    private void useForByMap(List<Student> students) {
        Map<String, Student> map = new HashMap<>();
        for (Student student : students) {
            map.put(student.getStudentNumber() + student.getStudentName(), student);
        }
        int count = map.keySet().size();
        System.out.println("List列表中的元素是对象类型，使用For循环利用Map的key值不重复通过对象中的学号+姓名字段去重，计算有多少学生：" + count);
    }

    /**
     * List列表中的元素是对象类型，使用Stream利用HashMap通过对象中的学号+姓名字段去重，计算有多少学生
     * @param students 学生信息
     */
    private void useStreamByHashMap(List<Student> students) {
        long count = students.stream().map(student -> (student.getStudentNumber() + student.getStudentName())).distinct().count();
        System.out.println("List列表中的元素是对象类型，使用Stream利用Map通过对象中的学号+姓名字段去重，计算有多少学生：" + count);
    }

}
