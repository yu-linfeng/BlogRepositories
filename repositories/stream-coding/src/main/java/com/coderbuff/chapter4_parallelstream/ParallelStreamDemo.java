package com.coderbuff.chapter4_parallelstream;

import com.coderbuff.common.Student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 并行化流
 * @author okevin
 * @date 2020/3/18
 */
public class ParallelStreamDemo {

    public void parallel(List<Student> students) {
        students.parallelStream()
                .map(Student::getStudentNumber)
                .collect(Collectors.toList());
    }
}
