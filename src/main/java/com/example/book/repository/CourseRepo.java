package com.example.book.repository;

import com.example.book.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends CrudRepository<Course, Long> {

    Iterable<Course> findAllByCategory(String category);
}

