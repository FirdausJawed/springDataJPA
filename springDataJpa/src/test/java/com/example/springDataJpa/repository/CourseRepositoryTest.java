package com.example.springDataJpa.repository;

import com.example.springDataJpa.entity.Course;
import com.example.springDataJpa.entity.Student;
import com.example.springDataJpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository repository;

    @Test
    void printAllCourses() {
        List<Course> courses = repository.findAll();
        courses.forEach(System.out::println);
    }

    @Test
    void saveCourseWithTeacher() {
        Teacher t = Teacher.builder()
                .firstName("John")
                .lastName("Sina")
                .build();
        Course course = Course.builder()
                .title("Spring Data JPA")
                .credit(4)
                .teacher(t)
                .build();
        repository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable a = (Pageable) PageRequest.of(0, 3);
        Pageable b = (Pageable) PageRequest.of(1,2);

        List<Course> course = repository.findAll(a).getContent();

        course.forEach(System.out::println);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle = (Pageable) PageRequest.of(0, 3,Sort.by("title"));
        Pageable sortByDecCredit = (Pageable) PageRequest.of(1, 2,Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = (Pageable)
                PageRequest.of(1, 2,Sort.by("title")
                                .and(Sort.by("credit").descending()));

        List<Course> course = repository.findAll(sortByTitle).getContent();
    }

    @Test
    public void printFindByTitleContaining() {
        Pageable find = PageRequest.of(0, 3);
        List<Course> c = repository.findByTitleContaining("D",find).getContent();
        c.forEach(System.out::println);
    }

    @Test
    public void saveStudentWithCoursee() {
        Student s = Student.builder()
                .firstName("Husna")
                .lastName("quoraishai")
                .emailId("husna@ggmail.com")
                .build();

        Teacher t = Teacher.builder()
                .firstName("Jahangir")
                .lastName("quoraishai")
                .build();

        Course c = Course.builder()
                .title("C++")
                .credit(4)
                .teacher(t)
                .build();

        c.addStudent(s);
        repository.save(c);
    }
}