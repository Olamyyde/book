package com.example.book.service;

import com.example.book.exception.CourseNotFoundException;
import com.example.book.model.Course;
import com.example.book.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepo courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepo courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Optional<Course> getCourseById(long courseId) {
        return courseRepository.findById(courseId);
    }

    @Override
    public Iterable<Course> getCoursesByCategory(String category) {
        return courseRepository.findAllByCategory(category);
    }

    @Override
    public Iterable<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void updateCourse(Long courseId, Course course) {

        courseRepository.findById(courseId).ifPresent(dbCourse -> {
            dbCourse.setName(course.getName());
            dbCourse.setCategory(course.getCategory());
            dbCourse.setDescription(course.getDescription());
            dbCourse.setRating(course.getRating());

            courseRepository.save(dbCourse);
        });
        throw new CourseNotFoundException(String.format("No course with id %s is available", courseId));
    }

    @Override
    public void deleteCourses() {
        courseRepository.deleteAll();
    }

    @Override
    public void deleteCourseById(long courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException(String.format("No course with id %s is available", courseId)));
        courseRepository.delete(course);
    }
}
