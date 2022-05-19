package com.core.coursemanage.repo;

import com.core.coursemanage.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description TODO
 * @Author rhmangmang
 * @Date 2022-05-19 01:18
 * @Version 1.0
 */
@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
    void deleteByStudentId(Long studentId);
}
