package com.practise.SpringSecurity.Repository;

import com.practise.SpringSecurity.Entity.Course;
import com.practise.SpringSecurity.Entity.Student;
import com.practise.SpringSecurity.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository repository;

    @Test
    public void printAllCourses() {
        List<Course> all = repository.findAll();
        System.out.println(all);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Arvind")
                .lastName("Singh")
                .build();

        Course course = Course.builder()
                .courseTitle("Java Programming")
                .credit(4)
                .teacher(teacher)
                .build();

        repository.save(course);
    }

    @Test
    public void findAllPagination(){
        PageRequest firstPageWithThreeRecord = PageRequest.of(0, 3);
        PageRequest secondPageWithThreeRecord = PageRequest.of(1, 2);

        List<Course> courses = repository.findAll(firstPageWithThreeRecord).getContent();
        System.out.println("First Page with 3 records: " + courses);

        int totalPages = repository.findAll(firstPageWithThreeRecord).getTotalPages();
        System.out.println("Total Pages: " + totalPages);

        Long totalElements = repository.findAll(firstPageWithThreeRecord).getTotalElements();
        System.out.println("Total Elements: " + totalElements);
    }

    @Test
    public void findAllSorting(){
        PageRequest sortByTitle = PageRequest.of(
                0,
                2,
                Sort.by("courseTitle").ascending()
        );

        PageRequest sortByTitleDesc = PageRequest.of(
                0,
                2,
                Sort.by("courseTitle").descending()
        );

        PageRequest sortByCreditDesc = PageRequest.of(
                0,
                2,
                Sort.by("credit").descending()
        );

        PageRequest sortByTitleAndCreditDesc = PageRequest.of(
                0,
                2,
                Sort.by("courseTitle").descending().and(Sort.by("credit"))
        );

        List<Course> courses = repository.findAll(sortByTitle).getContent();

    }

    @Test
    public void findByCourseTitleContaining(){
        PageRequest firstPageWithTenRecords = PageRequest.of(0, 10);
        List<Course> courses = repository.findByCourseTitleContaining("J", firstPageWithTenRecords);
        System.out.println("Courses containing 'J': " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
    Teacher teacher = Teacher.builder()
                .firstName("Arvind")
                .lastName("Singh")
                .build();

        Student student = Student.builder()
                .studentFirstName("Abhishek")
                .studentLastName("Singh")
                .emailId("Abhishek@gmail.com")
                .build();

        Course course = Course.builder()
                .courseTitle("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudent(student);
        repository.save(course);
    }
}