package com.practise.SpringSecurity.Repository;

import com.practise.SpringSecurity.Entity.Course;
import com.practise.SpringSecurity.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseDSA = Course.builder()
                .courseTitle("DSA")
                .credit(3)
                .build();

        Course courseJava = Course.builder()
                .courseTitle("Java")
                .credit(3)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("John")
                .lastName("Doe")
//                .courses(List.of(courseDSA, courseJava))
                .build();

        teacherRepository.save(teacher);
    }
}