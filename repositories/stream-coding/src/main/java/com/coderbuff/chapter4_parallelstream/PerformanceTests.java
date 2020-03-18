package com.coderbuff.chapter4_parallelstream;

import com.coderbuff.common.Student;
import com.coderbuff.common.StudentData;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * for循环、串行化流、并行化流性能对比
 * @author okevin
 * @date 2020/3/18
 */
public class PerformanceTests {

    public static void main(String[] args) {
        PerformanceTests performanceTests = new PerformanceTests();
        performanceTests.testStudents(new StudentData().fetchStudents(9), 9);
        performanceTests.testStudents(new StudentData().fetchStudents(90), 90);
        performanceTests.testStudents(new StudentData().fetchStudents(900), 900);
        performanceTests.testStudents(new StudentData().fetchStudents(9000), 9000);
        performanceTests.testStudents(new StudentData().fetchStudents(90000), 90000);
        performanceTests.testStudents(new StudentData().fetchStudents(900000), 900000);
        performanceTests.testStudents(new StudentData().fetchStudents(9000000), 9000000);
    }

    /**
     * 测试90个学生数据的性能
     * @param students 90个学生数据
     */
    public void testStudents(List<Student> students, int count) {
        System.out.println("【测试" + count + "个学生数据的性能】");
        testStudentsByFor(students);
        testStudentsByStream(students);
        testStudentsByParallelStream(students);
    }



    private void testStudentsByFor(List<Student> students) {
        long start = System.currentTimeMillis();
        System.out.println("--for--");
        List<Long> studentNumbers = new ArrayList<>();
        for (Student student : students) {
            studentNumbers.add(student.getStudentNumber());
        }
        System.out.println("for循环耗费时间：" + (System.currentTimeMillis() - start) + "ms");
    }

    private void testStudentsByStream(List<Student> students) {
        long start = System.currentTimeMillis();
        System.out.println("--Stream--");
        List<Long> studentNumbers = students.stream()
                .map(Student::getStudentNumber)
                .collect(Collectors.toList());
        System.out.println("串行化Stream耗费时间：" + (System.currentTimeMillis() - start) + "ms");
    }

    private void testStudentsByParallelStream(List<Student> students) {
        long start = System.currentTimeMillis();
        System.out.println("--parallel Stream--");
        List<Long> studentNumbers = students.parallelStream()
                .map(Student::getStudentNumber)
                .collect(Collectors.toList());
        System.out.println("并行化Stream耗费时间：" + (System.currentTimeMillis() - start) + "ms");
    }
}
