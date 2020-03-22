package com.sunjian.repository;

import com.sunjian.entity.Course;

/**
 * @author sunjian
 * @date 2020/3/22 15:56
 */
public interface CourseRepository {
    public Course findCourseById(Integer id);
}
