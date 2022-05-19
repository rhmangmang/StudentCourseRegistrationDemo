package com.core.coursemanage.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Description TODO
 * @Author rhmangmang
 * @Date 2022-05-19 00:05
 * @Version 1.0
 */

@Setter
@Getter
@Entity
public class StudentCourse implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "course_id")
    private Long courseId;

    /** student' score */
    @Column(name = "score")
    private Float score;

    @CreatedDate
    @Column(name = "gmt_create")
    protected Date gmtCreate;

    @LastModifiedDate
    @Column(name = "gmt_modified")
    protected Date gmtModified;
}
