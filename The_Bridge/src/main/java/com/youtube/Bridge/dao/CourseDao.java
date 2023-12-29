package com.youtube.Bridge.dao;

import com.youtube.Bridge.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CourseDao extends CrudRepository<Course,Integer> {
}
