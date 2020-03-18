package com.coderbuff.chapter5_action.chapter5_1;

import com.coderbuff.common.Student;
import com.coderbuff.common.StudentData;

import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 场景六：将学生List按学号相同的进行分组，key=学号，value=学生集合，同时key键按从小到大字典序排序。
 * @author okevin
 * @date 2020/3/18 22:41
 */
public class Scene6 {

    public static void main(String[] args) {
        Scene6 scene6 = new Scene6();
        TreeMap<Long, List<Student>> treeMap = scene6.groupingStudentByStudentNumber(new StudentData().getStudentData());
        System.out.println(treeMap);
    }

    /**
     * collect 流 -> 集合
     * Collectors.groupingBy 分组，第一个参数表示key键，第二个参数表示返回类型，value值按List结合收集
     * @param students 学生信息
     * @return key=学号，value=学生集合，key键按字典序
     */
    private TreeMap<Long, List<Student>> groupingStudentByStudentNumber(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getStudentNumber, TreeMap::new, Collectors.toList()));
    }
}
