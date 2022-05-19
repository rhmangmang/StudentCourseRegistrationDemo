package com.core.coursemanage.service;

import com.core.coursemanage.entity.Course;
import com.core.coursemanage.repo.CourseRepository;
import com.core.coursemanage.entity.Student;
import com.core.coursemanage.entity.StudentCourse;
import com.core.coursemanage.repo.StudentCourseRepository;
import com.core.coursemanage.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author rhmangmang
 * @Date 2022-05-19 00:20
 * @Version 1.0
 */

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TransactionDefinition transactionDefinition;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Override
    public void addNewStudentWithCourseRegistrations(Student student, List<Course> courseList) {
        // TODO: 2022-05-19 1. use try-catch clause and retry the execution if one of them failed
        //  2.print related info and send failed course to middleware like Kafka, so that we can trigger a task to retry it or people can deal with it later on.

        Student saveStudent = studentRepository.save(student);

        StudentCourse studentCourse = new StudentCourse();
        for (Course course : courseList) {
            studentCourse.setStudentId(saveStudent.getId());
            studentCourse.setCourseId(course.getId());
            studentCourse.setScore(11f);
            studentCourse.setGmtCreate(new Date());
            studentCourse.setGmtModified(new Date());
            studentCourseRepository.save(studentCourse);
        }
    }

    @Override
    public void deleteStudent(long studentId) {
        TransactionStatus transaction = platformTransactionManager.getTransaction(transactionDefinition);
        try {
            // also need to delete the student's info in StudentCourse table.
            studentCourseRepository.deleteByStudentId(studentId);
            studentRepository.deleteById(studentId);
        } catch (Exception e) {
            platformTransactionManager.rollback(transaction);
            throw e;
        }
        platformTransactionManager.commit(transaction);
    }

    @Override
    public List<Student> findStudentsByCourseName(String courseName) {
        List<Student> foundStudents = new ArrayList<>();

        // courseName may not be just one.
        List<Course> courses = courseRepository.findCoursesByName(courseName);
        for (Course course : courses) {
            List<Student> students = studentRepository.findStudentsByCourseId(course.getId());
            foundStudents.addAll(students);
        }

        return foundStudents;
    }

    @Override
    public List<Student> findStudentsByNotRegisterThisCourse(String courseName) {
        List<Student> foundStudents = new ArrayList<>();

        List<Course> courses = courseRepository.findCoursesByName(courseName);

        for (Course course : courses) {
            List<Student> students = studentRepository.findStudentsByNotRegisterThisCourse(course.getId());
            foundStudents.addAll(students);
        }

        return foundStudents;
    }
}
