package com.coderbuff.chapter5_action.chapter5_1;

import com.coderbuff.common.Student;
import com.coderbuff.common.StudentData;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 场景四：将学生集合转换为Map类型，key=学号，value=学生
 * @author okevin
 * @date 2020/3/18
 */
public class Scene4 {

    public static void main(String[] args) {
        Scene4 scene4 = new Scene4();
        Map<Long, Student> map = scene4.translateMap(new StudentData().getStudentData());
        System.out.println(map);
    }


    /**
     * collect 流->集合
     * Collectors.toMap 转换为Map类型
     * @param students 学生集合
     * @return key=学号，value=学生信息
     */
    private Map<Long, Student> translateMap(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(Student::getStudentNumber, student -> student, (studentNumber1, studentNumber2) -> studentNumber2));
    }
}
