package com.example.springDataJpa.repository;

import com.example.springDataJpa.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Page<Course> findByTitleContaining(String title, Pageable pageable);
}
