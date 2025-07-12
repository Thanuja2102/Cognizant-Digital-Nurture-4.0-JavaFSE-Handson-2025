package com.cognizant.springlearn.service.impl;

import com.cognizant.springlearn.model.Course;
import com.cognizant.springlearn.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private static final List<Course> courseList = new ArrayList<>();

    static {
        courseList.add(new Course(1, "Spring Core", "Emma Watson"));
        courseList.add(new Course(2, "Spring Boot", "John Doe"));
        courseList.add(new Course(3, "Microservices", "Robert Fox"));
    }

    public List<Course> getAllCourses() {
        return courseList;
    }

    public Course getCourseById(long id) {
        return courseList.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
