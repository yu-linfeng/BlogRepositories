package com.coderbuff.common;

/**
 * @author yulinfeng
 * @date 2020/2/28
 */
public class Student {
    private Long id;
    private Long studentNumber;
    private String studentName;
    private String course;
    private Double score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Long studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentNumber=" + studentNumber +
                ", studentName='" + studentName + '\'' +
                ", course='" + course + '\'' +
                ", score=" + score +
                '}';
    }
}
