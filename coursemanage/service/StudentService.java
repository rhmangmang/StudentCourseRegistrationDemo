package com.core.coursemanage.service;

import com.core.coursemanage.entity.Course;
import com.core.coursemanage.entity.Student;

import java.util.List;

/**
 * @Description TODO
 * @Author rhmangmang
 * @Date 2022-05-19 00:13
 * @Version 1.0
 */

public interface StudentService {
    public void addNewStudentWithCourseRegistrations(Student student, List<Course> course);

    public void deleteStudent(long studentId);

    public List<Student> findStudentsByCourseName(String courseName);

    public List<Student> findStudentsByNotRegisterThisCourse(String courseName);
}
