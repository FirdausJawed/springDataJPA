package com.example.springDataJpa.repository;

import com.example.springDataJpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String name);

    List<Student> findByFirstNameContaining(String name);

    //jpql
    @Query("select s from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailId(String emailId);


    @Query(
            value = "SELECT * FROM student_db.students_ka_db s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailIdNative(String emailId);

    @Query(
            value = "SELECT * FROM student_db.students_ka_db s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailIdNativeByNamedParam(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "update student_ka_db set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String emailId, String name);
}
