package com.coderbuff.chapter5_action.chapter5_1;

import com.coderbuff.common.Student;
import com.coderbuff.common.StudentData;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 场景八：学生的语文成绩乘以30%，数学成绩50%，英语成绩20%，计算每个学生加权总成绩，并按Map返回，key=学生姓名，value=学生加权后的总成绩。
 * @author okevin
 * @date 2020/3/18
 */
public class Scene8 {

    public static void main(String[] args) {
        Scene8 scene8 = new Scene8();
        Map<Long, Double> map = scene8.calcWeightTotalScore(new StudentData().getStudentData());
        System.out.println(map);
    }

    /**
     * collect 流->集合
     * peek 处理流中的List数据
     * Collectors.groupingBy 分组
     * Collectors.summingDouble double类型数据求和
     * @param students 学生信息
     * @return key=学号，value=总成绩。
     */
    private Map<Long, Double> calcWeightTotalScore(List<Student> students) {

        Map<Long, Double> map = students.stream()
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

        return map;
    }
}
