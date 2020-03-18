package com.coderbuff.chapter3_stream.chapter3_4;

import com.coderbuff.common.Student;
import com.coderbuff.common.StudentData;

import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Stream summaryStatistics求和计算
 * @author yulinfeng
 * @date 2020/3/18
 */
public class StreamSummaryStatisticsDemo {

    public static void main(String[] args) {
        StreamSummaryStatisticsDemo streamSummaryStatisticsDemo = new StreamSummaryStatisticsDemo();
        streamSummaryStatisticsDemo.calc(new StudentData().getStudentData());
    }

    /**
     * 学生类型的集合常用计算
     * @param students 学生
     */
    private void calc(List<Student> students) {
        DoubleSummaryStatistics summaryStatistics = students.stream()
                .mapToDouble(Student::getScore)
                .summaryStatistics();
        System.out.println("平均分：" + summaryStatistics.getAverage());
        System.out.println("总分：" + summaryStatistics.getSum());
        System.out.println("最高分：" + summaryStatistics.getMax());
        System.out.println("最低分：" + summaryStatistics.getMin());
    }
}
