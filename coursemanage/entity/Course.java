
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
 * @Date 2022-05-19 00:03
 * @Version 1.0
 */

@Setter
@Getter
@Entity
public class Course implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** course's name */
    @Column(name = "name")
    private String name;

    @CreatedDate
    @Column(name = "gmt_create")
    protected Date gmtCreate;

    @LastModifiedDate
    @Column(name = "gmt_modified")
    protected Date gmtModified;
}
