package com.coderbuff.chapter5_action.chapter5_1;

import com.coderbuff.common.Student;
import com.coderbuff.common.StudentData;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 场景五：将学生集合按学号相同的进行分组，key=学号，value=学生集合。
 * @author okevin
 * @date 2020/3/18
 */
public class Scene5 {

    public static void main(String[] args) {
        Scene5 scene5 = new Scene5();
        Map<Long, List<Student>> map = scene5.groupingStudentByStudentNumber(new StudentData().getStudentData());
        System.out.println(map);
    }

    /**
     * collect 流->集合
     * Collectors.groupingBy 分组
     * @param students 学生信息
     * @return 按学号分组Map
     */
    private Map<Long, List<Student>> groupingStudentByStudentNumber(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getStudentNumber));
    }
}
