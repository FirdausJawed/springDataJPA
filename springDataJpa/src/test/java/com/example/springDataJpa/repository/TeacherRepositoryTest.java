package com.example.springDataJpa.repository;

import com.example.springDataJpa.entity.Course;
import com.example.springDataJpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    TeacherRepository teacherRepository;

    @Test
    void saveTeacher() {
        Course sub1 = Course.builder()
                .title("Math")
                .credit(5)
                .build();

        Course sub2 = Course.builder()
                .title("CP")
                .credit(7)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("vikas")
                .lastName("sir")
//                .course(List.of(sub1, sub2))
                .build();
        teacherRepository.save(teacher);
    }
}