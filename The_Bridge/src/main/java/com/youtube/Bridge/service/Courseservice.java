package com.youtube.Bridge.service;

import com.youtube.Bridge.dao.CourseDao;
import com.youtube.Bridge.entity.Course;
import org.springframework.stereotype.Service;

@Service
public class Courseservice {
    private CourseDao courseDao;
    public Course addnewcourse(Course course){
        return courseDao.save(course);


    }
    public void initCourse(){
        Course firstCourse = new Course();
        firstCourse .setCourseId(1);
        firstCourse .setCoursename("DevOps");
        firstCourse .setCourseprice(500);
        courseDao.save(firstCourse);

    }
}
