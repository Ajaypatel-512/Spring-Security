package com.practise.SpringSecurity.Repository;

import com.practise.SpringSecurity.Entity.Guardian;
import com.practise.SpringSecurity.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("ajay@gmail.com")
                .studentFirstName("Ajay")
                .studentLastName("Sharma")
//                .guardianName("Ramesh Sharma")
//                .guardianEmail("ramesh@gmail.com")
//                .guardianMobile("9876543210")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .name("Shivam Kumar")
                .email("shivam@gmail.com")
                .mobile("9876543210")
                .build();

        Student student = Student.builder()
                .studentFirstName("Aman")
                .studentLastName("Kumar")
                .emailId("aman@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }

    @Test
    public void printAllStudent(){
        List<Student> all = studentRepository.findAll();
        System.out.println("Student List: " + all);
    }

    @Test
    public void findByStudentFirstName(){
        List<Student> students = studentRepository.findByStudentFirstName("Ajay");
        System.out.println("Students with first name Ajay: " + students);
    }

    @Test
    public void findByStudentFirstNameContaining(){
        List<Student> students = studentRepository.findByStudentFirstNameContaining("am");
        System.out.println("Students with first name containing 'am': " + students);
    }

    @Test
    public void findByStudentLastNameNotNull(){
        List<Student> students = studentRepository.findByStudentLastNameNotNull();
        System.out.println("Students with last name not null: " + students);
    }

    @Test
    public void findByGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Shivam");
        System.out.println("Students with guardian name Shivam: " + students);
    }

    @Test
    public void findStudentByEmailId() {
        Student student = studentRepository.getStudentByEmailId("Ajay@gmail.com");
        System.out.println("Student with email " + ": " + student);
    }

    @Test
    public void getStudentFirstNameByEmailId(){
        String student = studentRepository.getStudentFirstNameByEmailId("Ajay@gmail.com");
        System.out.println("Student first name with email " + ": " + student);
    }

    @Test
    public void getStudentByEmailIdNative(){
        Student student = studentRepository.getStudentByEmailIdNative("ajay@gmail.com");
        System.out.println("Student with email " + ": " + student);
    }

    @Test
    public void getStudentByEmailIdNativeNameParam(){
        Student student = studentRepository.getStudentByEmailIdNativeNameParam("ajay@gmail.com");
        System.out.println("Student with email " + ": " + student);
    }

    @Test
    public void updateStudentFirstNameByEmailId(){
        studentRepository.updateStudentFirstNameByEmailId("Ajay singh","ajay@gmail.com");
    }


}