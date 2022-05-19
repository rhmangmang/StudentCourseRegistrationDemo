package com.core.coursemanage.entity;

import lombok.AllArgsConstructor;
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
 * @Date 2022-05-18 23:59
 * @Version 1.0
 */

@Setter
@Getter
@Entity
@AllArgsConstructor
public class Student implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** student'name */
    @Column(name = "name")
    private String name;

    @CreatedDate
    @Column(name = "gmt_create")
    protected Date gmtCreate;

    @LastModifiedDate
    @Column(name = "gmt_modified")
    protected Date gmtModified;

    public Student () {

    }

}
