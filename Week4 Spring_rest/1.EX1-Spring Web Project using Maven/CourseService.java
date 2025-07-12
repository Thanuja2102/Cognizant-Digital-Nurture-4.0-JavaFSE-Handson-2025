package com.cognizant.springlearn.service;

import com.cognizant.springlearn.model.Course;
import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(long id);
}
