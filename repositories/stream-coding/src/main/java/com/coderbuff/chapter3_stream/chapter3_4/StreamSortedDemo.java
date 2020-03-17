package com.coderbuff.chapter3_stream.chapter3_4;

import com.coderbuff.common.Student;
import com.coderbuff.common.StudentData;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author okevin
 * @date 2020/3/17
 */
public class StreamSortedDemo {

    public static void main(String[] args) {
        StreamSortedDemo streamSortedDemo = new StreamSortedDemo();

        System.out.println("--comparator--");
        List<Student> originalStudents1 = new StudentData().getStudentData();
        List<Student> sortedByComparatorList = streamSortedDemo.sortedByComparator(originalStudents1);
        sortedByComparatorList.forEach(System.out::println);

        System.out.println("--for--");
        List<Student> originalStudents2 = new StudentData().getStudentData();
        List<Student> sortedByFor = streamSortedDemo.sortedByFor(originalStudents2);
        sortedByFor.forEach(System.out::println);

        System.out.println("--Stream sorted--");
        List<Student> originalStudents3 = new StudentData().getStudentData();
        List<Student> sortedByStreamSorted = streamSortedDemo.sortedByStreamSorted(originalStudents3);
        sortedByStreamSorted.forEach(System.out::println);
    }

    /**
     * 通过Collections.sort静态方法 + Comparator匿名内部类对学生成绩进行排序
     * @param students 待排序学生集合
     * @return 排好序的学生集合
     */
    private List<Student> sortedByComparator(List<Student> students) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                return student1.getScore().compareTo(student2.getScore());
            }
        });
        return students;
    }

    /**
     * 使用冒泡排序算法对学生成绩进行排序
     * @param students 待排序学生集合
     * @return 排好序的学生集合
     */
    private List<Student> sortedByFor(List<Student> students) {

        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() - 1 - i; j++) {
                if (students.get(j).getScore().compareTo(students.get(j + 1).getScore()) > 0) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
        return students;
    }

    /**
     * 通过Stream sorted对学生成绩进行排序
     * @param students 待排序学生集合
     * @return 排好序的学生集合
     */
    private List<Student> sortedByStreamSorted(List<Student> students) {
        return students.stream()
                       .sorted(Comparator.comparing(Student::getScore).reversed())
                       .collect(Collectors.toList());
    }
}
