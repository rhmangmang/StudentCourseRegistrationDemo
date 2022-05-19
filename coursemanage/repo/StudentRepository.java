package com.core.coursemanage.repo;

import com.core.coursemanage.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author rhmangmang
 * @Date 2022-05-19 00:40
 * @Version 1.0
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "select new com.ueboot.core.coursemanage.entity.Student(s.id, s.name, s.gmtCreate, s.gmtModified) from Student as s " +
            "where s.id in (select sc.studentId from StudentCourse as sc where sc.courseId = ?1) order by s.name")
    List<Student> findStudentsByCourseId(Long courseId);


    @Query(value = "select new com.ueboot.core.coursemanage.entity.Student(s.id, s.name, s.gmtCreate, s.gmtModified) from Student as s" +
            " where s.id not in (select sc.studentId From StudentCourse as sc where sc.courseId = ?1)")
    List<Student> findStudentsByNotRegisterThisCourse(Long courseId);
}
