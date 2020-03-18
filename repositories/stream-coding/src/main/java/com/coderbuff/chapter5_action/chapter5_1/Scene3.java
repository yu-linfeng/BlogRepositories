package com.coderbuff.chapter5_action.chapter5_1;

import com.coderbuff.common.Student;
import com.coderbuff.common.StudentData;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 场景三：将学生集合转换为Map类型，key=学号，value=姓名。
 * @author okevin
 * @date 2020/3/18
 */
public class Scene3 {

    public static void main(String[] args) {
        Scene3 scene3 = new Scene3();
        Map<Long, String> map = scene3.translateMap(new StudentData().getStudentData());
        System.out.println(map);
    }

    /**
     * collect 流->集合
     * Collectors.toMap 转换为Map类型
     * @param students 学生集合
     * @return key=学号，value=姓名
     */
    private Map<Long, String> translateMap(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(Student::getStudentNumber, Student::getStudentName, (studentNumber1, studentNumber2) -> studentNumber2));
    }

}
