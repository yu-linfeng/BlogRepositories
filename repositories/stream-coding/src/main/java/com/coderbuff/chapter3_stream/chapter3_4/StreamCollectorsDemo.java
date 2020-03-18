package com.coderbuff.chapter3_stream.chapter3_4;

import com.coderbuff.common.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Collectors收集器
 * @author okevin
 * @date 2020/3/18
 */
public class StreamCollectorsDemo {

    /**
     * 将学生类型的集合转换为只包含名字的集合
     * @param students 学生集合
     * @return 学生姓名集合
     */
    private List<String> translateNames(List<Student> students) {

        return students.stream()
                       .map(Student::getStudentName)
                       .collect(Collectors.toList());
    }

    /**
     * 将学生类型的集合转换为Map类型，key=学号，value=学生
     * @param students 学生集合
     * @return 学生Map
     */
    private Map<Long, Student> translateStudentMap(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(Student::getStudentNumber, student -> student));
    }

    /**
     * 按学生的学号对学生集合进行分组返回Map，key=学生学号，value=学生集合
     * @param students 学生集合
     * @return 按学号分组的Map
     */
    private Map<Long, List<Student>> studentGroupByStudentNumber(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getStudentNumber));
    }
}
