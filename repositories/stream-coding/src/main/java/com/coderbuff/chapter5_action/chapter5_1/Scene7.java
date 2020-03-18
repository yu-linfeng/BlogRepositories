package com.coderbuff.chapter5_action.chapter5_1;

import com.coderbuff.common.Student;
import com.coderbuff.common.StudentData;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 场景七：计算每个学生的总成绩（语文+数学+英语），并按Map结构返回，key=学号，value=总成绩。
 * @author okevin
 * @date 2020/3/18 22:20
 */
public class Scene7 {

    public static void main(String[] args) {
        Scene7 scene7 = new Scene7();
        Map<Long, Double> map = scene7.calcTotalScore(new StudentData().getStudentData());
        System.out.println(map);
    }

    /**
     * collect 流->集合
     * Collectors.groupingBy 分组
     * Collectors.summingDouble double类型数据求和
     * @param students 学生信息
     * @return key=学号，value=总成绩。
     */
    private Map<Long, Double> calcTotalScore(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getStudentNumber, Collectors.summingDouble(Student::getScore)));

    }
}
