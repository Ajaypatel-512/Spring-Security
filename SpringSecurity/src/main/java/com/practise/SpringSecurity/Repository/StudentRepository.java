package com.practise.SpringSecurity.Repository;

import com.practise.SpringSecurity.Entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

    public List<Student> findByStudentFirstName(String studentFirstName);
    public List<Student> findByStudentFirstNameContaining(String studentFirstName);
    public List<Student> findByStudentLastNameNotNull();
    public List<Student> findByGuardianName(String guardianName);
    public List<Student> findByStudentFirstNameAndStudentLastName(String studentFirstName, String studentLastName);

    @Query("select s from Student s where s.emailId = ?1")
    public Student getStudentByEmailId(String emailId);

    @Query("select s.studentFirstName from Student s where s.emailId = ?1")
    public String getStudentFirstNameByEmailId(String emailId);

    //Native Query Example
    @Query(
            value = "select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    public Student getStudentByEmailIdNative(String emailId);

    //Native query Named Parameter Example
    @Query(
            value = "select * from tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    public Student getStudentByEmailIdNativeNameParam(@Param("emailId") String emailId);


    //Update the first name of the student by email id
    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student s set s.student_first_name = ?1 where s.email_address = ?2",
            nativeQuery = true
    )
    int updateStudentFirstNameByEmailId(String firstName, String emailId);


}
