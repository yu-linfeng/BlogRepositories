package com.coderbuff.chapter5_action.chapter5_1;

import com.coderbuff.common.Student;
import com.coderbuff.common.StudentData;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yulinfeng
 * @date 2020/3/18
 */
public class Scene7 {

    public static void main(String[] args) {
        Scene7 scene7 = new Scene7();
        Map<Long, Double> map = scene7.calcWeightTotalScore(new StudentData().getStudentData());
        System.out.println(map);
    }

    private Map<Long, Double> calcWeightTotalScore(List<Student> students) {
        return students.stream()
                .peek(student -> {
                    if (student.getCourse().equals("语文")) {
                        student.setScore(student.getScore() * 0.3);
                    } else if (student.getCourse().equals("数学")) {
                        student.setScore(student.getScore() * 0.5);
                    } else if (student.getCourse().equals("英语")) {
                        student.setScore(student.getScore() * 0.2);
                    }
                })
                .collect(Collectors.groupingBy(Student::getStudentNumber, Collectors.summingDouble(Student::getScore)));
    }
}
