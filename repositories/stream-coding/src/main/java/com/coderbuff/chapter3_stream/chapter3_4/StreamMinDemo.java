package com.coderbuff.chapter3_stream.chapter3_4;

import com.coderbuff.common.Student;
import com.coderbuff.common.StudentData;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Stream min操作
 * @author okevin
 * @date 2020/3/18 00:25
 */
public class StreamMinDemo {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 7, 5, 9, 1);

        StreamMinDemo streamMinDemo = new StreamMinDemo();
        Integer minByFor = streamMinDemo.minByFor(numbers);
        System.out.println("--for--");
        System.out.println(minByFor);

        Integer minByStreamMin = streamMinDemo.minByStreamMin(numbers);
        System.out.println("--Stream min--");
        System.out.println(minByStreamMin);

        Double minScoreByStreamMin = streamMinDemo.minScoreByStreamMin(new StudentData().getStudentData());
        System.out.println("--Stream min score--");
        System.out.println(minScoreByStreamMin);
    }

    /**
     * 通过for循环计算集合中的最小值
     * @param numbers 集合
     * @return 最小值
     */
    private Integer minByFor(List<Integer> numbers) {
        Integer min = numbers.get(0);
        for (Integer number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    /**
     * 通过Stream min计算集合中的最小值
     * @param numbers 集合
     * @return 最小值
     */
    private Integer minByStreamMin(List<Integer> numbers) {
        return numbers.stream()
                      .min(Comparator.comparingInt(Integer::intValue)).get();
    }

    /**
     * 通过Stream min计算学生集合中的最低成绩
     * @param students 学生集合
     * @return 最低成绩
     */
    private Double minScoreByStreamMin(List<Student> students) {
        Student minScoreStudent = students.stream()
                .min(Comparator.comparing(Student::getScore)).get();
        return minScoreStudent.getScore();
    }
}
