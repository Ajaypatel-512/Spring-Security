package com.practise.SpringSecurity.Repository;

import com.practise.SpringSecurity.Entity.Course;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByCourseTitleContaining(String courseTitle, Pageable pageable);
}
