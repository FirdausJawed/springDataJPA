package com.example.springDataJpa.repository;

import com.example.springDataJpa.entity.Guardian;
import com.example.springDataJpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    void saveStudent() {
        Student student = Student.builder()
                .emailId("abc@gmail.com")
                .firstName("fj")
                .lastName("jj")
//                .guardianEmailId("abc")
//                .guardianName("abbu ji")
//                .guardianMobile("9999999999")
                .build();
        studentRepository.save(student);
    }

    @Test
    void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("abbu")
                .email("abbu@gmail.com")
                .mobile("999999999999").build();

        Student student = Student.builder()
                .emailId("abcde@gmail.com")
                .firstName("firdaus")
                .lastName("jawed")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    void printAllStudents() {
        List<Student> students = studentRepository.findAll();
        students.forEach(System.out::println);
    }

    @Test
    void findStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("firdaus");
        students.forEach(System.out::println);
    }

    @Test
    void findStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("fir");
        students.forEach(System.out::println);
    }

    @Test
    void printStudentByEmailId() {
        String student = studentRepository.getStudentFirstNameByEmailId("abc@gmail.com");
        System.out.println(student);
    }

    @Test
    void printgetStudentByEmailIdNative(){
        Student student = studentRepository.getStudentByEmailIdNative("abc@gmail.com");
        System.out.println(student);
    }

    @Test
    void getStudentByEmailIdNativeByNamedParam(){
        Student student = studentRepository.getStudentByEmailIdNative("abc@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailIdTest (String firstname, String emailId) {
        int student = studentRepository.updateStudentNameByEmailId("firdaus", "abc@gmail.com");
    }
}