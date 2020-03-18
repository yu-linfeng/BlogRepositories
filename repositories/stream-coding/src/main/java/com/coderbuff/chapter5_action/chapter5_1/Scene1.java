package com.coderbuff.chapter5_action.chapter5_1;

import com.coderbuff.common.Student;
import com.coderbuff.common.StudentData;

import java.util.List;

/**
 * 场景一：通过学号，计算一共有多少个学生。
 * @author okevin
 * @date 2020/3/18
 */
public class Scene1 {

    public static void main(String[] args) {
        Scene1 scene1 = new Scene1();
        long count = scene1.calcStudentNumber(new StudentData().getStudentData());
        System.out.println(count);
    }

    /**
     * map 按学生的学号转换为新的数据结构类型
     * distinct 去重
     * count 计数
     * @param students 学生
     * @return 去重后的学生数量
     */
    private long calcStudentNumber(List<Student> students) {
        return students.stream()
                .map(Student::getStudentNumber)
                .distinct()
                .count();
    }
}
