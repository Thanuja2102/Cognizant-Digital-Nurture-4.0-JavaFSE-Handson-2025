package com.cognizant.spring_learn;

import com.cognizant.springlearn.model.Course;
import com.cognizant.springlearn.service.impl.CourseServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SpringLearnApplicationTests {

	private CourseServiceImpl service;

	@Before
	public void setUp() {
		service = new CourseServiceImpl();
	}

	@Test
	public void testGetAllCourses() {
		List<Course> list = service.getAllCourses();
		Assert.assertEquals(3, list.size());
	}

	@Test
	public void testGetCourseById_Found() {
		Course course = service.getCourseById(1);
		Assert.assertEquals("Spring Core", course.getName());
	}

	@Test
	public void testGetCourseById_NotFound() {
		Course course = service.getCourseById(100);
		Assert.assertNull(course);
	}
}

