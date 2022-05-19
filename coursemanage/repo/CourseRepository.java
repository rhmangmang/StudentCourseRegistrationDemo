package com.core.coursemanage.repo;

import com.core.coursemanage.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description TODO
 * @Author rhmangmang
 * @Date 2022-05-19 11:58
 * @Version 1.0
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findCoursesByName(String name);
}
