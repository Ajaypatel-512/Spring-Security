package com.practise.SpringSecurity.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "course_material_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long courseMaterialId;
    private String url;
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false // Assuming every CourseMaterial must be associated with a Course
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course; // Assuming this is a foreign key to Course entity
}
