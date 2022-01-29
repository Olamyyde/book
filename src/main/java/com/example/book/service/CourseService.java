package com.example.book.service;

import com.example.book.model.Course;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface CourseService {
    Course createCourse(Course course);

    Optional<Course> getCourseById(long courseId);

    Iterable<Course> getCoursesByCategory(String category);

    Iterable<Course> getCourses();

    void updateCourse(Long courseId, Course course);

    void deleteCourseById(long courseId);

    void deleteCourses();
}
