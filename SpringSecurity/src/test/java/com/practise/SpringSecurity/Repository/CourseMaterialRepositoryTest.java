package com.practise.SpringSecurity.Repository;

import com.practise.SpringSecurity.Entity.Course;
import com.practise.SpringSecurity.Entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@DataJpaTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial() {
        Course course = Course.builder()
                .courseTitle("Spring Boot Basics")
                .credit(4)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("http://example.com/course-material")
                .course(course)
                .build();

        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial> all = repository.findAll();
        System.out.println(all);
    }

}