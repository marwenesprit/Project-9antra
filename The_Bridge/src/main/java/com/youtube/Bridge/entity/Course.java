package com.youtube.Bridge.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer courseId;
    private String coursename;
    private double courseprice;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="course_images",
    joinColumns = {
            @JoinColumn(name="course_id")
    },
            inverseJoinColumns = {
            @JoinColumn(name="image_id")
            }
    )
    private Set<ImageModel>courseImage;
    public Set<ImageModel> getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(Set<ImageModel> courseImage) {
        this.courseImage = courseImage;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public double getCourseprice() {
        return courseprice;
    }

    public void setCourseprice(double courseprice) {
        this.courseprice = courseprice;
    }
}
