package com.coderbuff.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yulinfeng
 * @date 2020/2/28
 */
public class StudentData {

    public List<Student> getStudentData() {
        List<Student> students = new ArrayList<>();
        Student kevin1 = new Student();
        kevin1.setId(1L);
        kevin1.setStudentNumber(20200001L);
        kevin1.setStudentName("Kevin");
        kevin1.setCourse("语文");
        kevin1.setScore(90.0);
        students.add(kevin1);

        Student zhangsan1 = new Student();
        zhangsan1.setId(2L);
        zhangsan1.setStudentNumber(20200002L);
        zhangsan1.setStudentName("张三");
        zhangsan1.setCourse("语文");
        zhangsan1.setScore(91.0);
        students.add(zhangsan1);

        Student kevin2 = new Student();
        kevin2.setId(3L);
        kevin2.setStudentNumber(20200001L);
        kevin2.setStudentName("Kevin");
        kevin2.setCourse("数学");
        kevin2.setScore(99.0);
        students.add(kevin2);

        Student lisi1 = new Student();
        lisi1.setId(4L);
        lisi1.setStudentNumber(20200003L);
        lisi1.setStudentName("李四");
        lisi1.setCourse("语文");
        lisi1.setScore(76.0);
        students.add(lisi1);

        Student lisi2 = new Student();
        lisi2.setId(5L);
        lisi2.setStudentNumber(20200003L);
        lisi2.setStudentName("李四");
        lisi2.setCourse("数学");
        lisi2.setScore(71.0);
        students.add(lisi2);

        Student kevin3 = new Student();
        kevin3.setId(6L);
        kevin3.setStudentNumber(20200001L);
        kevin3.setStudentName("Kevin");
        kevin3.setCourse("英语");
        kevin3.setScore(68.0);
        students.add(kevin3);

        Student zhangsan2 = new Student();
        zhangsan2.setId(7L);
        zhangsan2.setStudentNumber(20200002L);
        zhangsan2.setStudentName("张三");
        zhangsan2.setCourse("数学");
        zhangsan2.setScore(88.0);
        students.add(zhangsan2);

        Student zhangsan3 = new Student();
        zhangsan3.setId(8L);
        zhangsan3.setStudentNumber(20200002L);
        zhangsan3.setStudentName("张三");
        zhangsan3.setCourse("英语");
        zhangsan3.setScore(87.0);
        students.add(zhangsan3);

        Student lisi3 = new Student();
        lisi3.setId(9L);
        lisi3.setStudentNumber(20200003L);
        lisi3.setStudentName("李四");
        lisi3.setCourse("英语");
        lisi3.setScore(60.0);
        students.add(lisi3);

        return students;
    }
}
