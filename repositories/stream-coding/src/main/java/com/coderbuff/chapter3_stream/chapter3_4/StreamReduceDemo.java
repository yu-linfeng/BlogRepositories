package com.coderbuff.chapter3_stream.chapter3_4;

import com.coderbuff.common.Student;
import com.coderbuff.common.StudentData;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/**
 * @author okevin
 * @date 2020/3/17 22:35
 */
public class StreamReduceDemo {

    public static void main(String[] args) {
        StreamReduceDemo streamReduceDemo = new StreamReduceDemo();
        double totalScoreByStreamReduce = streamReduceDemo.calcTotalScoreByStreamReduce(new StudentData().getStudentData());
        System.out.println(totalScoreByStreamReduce);

        double totalScoreByFor = streamReduceDemo.calcTotalScoreByFor(new StudentData().getStudentData());
        System.out.println(totalScoreByFor);
    }

    /**
     * Optional<T> reduce(BinaryOperator<T> accumulator);
     * 使用没有初始值对集合中的元素进行累加
     * @param numbers 集合元素
     * @return 累加结果
     */
    private Integer calcTotal(List<Integer> numbers) {
        return numbers.stream()
                .reduce((total, number) -> total + number).get();
    }

    /**
     * T reduce(T identity, BinaryOperator<T> accumulator);
     * 赋初始值为1，对集合中的元素进行累加
     * @param numbers 集合元素
     * @return 累加结果
     */
    private Integer calcTotal2(List<Integer> numbers) {
        return numbers.stream()
                .reduce(1, (total, number) -> total + number);
    }

    /**
     * <U> U reduce(U identity,
     *                  BiFunction<U, ? super T, U> accumulator,
     *                  BinaryOperator<U> combiner);
     * 集合中的元素是"学生"对象，对学生的"score"分数字段进行累加
     * @param students 学生集合
     * @return 分数总和
     */
    private Double calcTotalScoreByStreamReduce(List<Student> students) {
        return students.stream()
                .reduce(Double.valueOf(0), new BiFunction<Double, Student, Double>() {
                    @Override
                    public Double apply(Double total, Student student) {
                        return total + student.getScore();
                    }
                }, new BinaryOperator<Double>() {
                    @Override
                    public Double apply(Double aDouble, Double aDouble2) {
                        System.out.println("第三个参数的作用");
                        return aDouble + aDouble2;
                    }
                });
    }

    /**
     * 通过for循环对集合中的学生成绩字段进行累加
     * @param students 学生集合
     * @return 分数总和
     */
    private Double calcTotalScoreByFor(List<Student> students) {
        double total = 0;
        for (Student student : students) {
            total += student.getScore();
        }
        return total;
    }

    /**
     * 先使用map将学生集合转换为分数的集合
     * 再使用reduce调用第一个重载方法计算总和
     * @param students 学生集合
     * @return 分数总和
     */
    private Double calcTotalScoreByStreamMapReduce(List<Student> students) {
        return students.stream()
                .map(Student::getScore)
                .reduce((total, score) -> total + score).get();
    }
}
