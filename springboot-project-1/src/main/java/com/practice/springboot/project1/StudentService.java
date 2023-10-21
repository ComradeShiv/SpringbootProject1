package com.practice.springboot.project1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public Student getStudent(int regNo) {
//        Student student = studentRepository.getStudent(regNo);
//        student.setAge(student.getAge() + 5);
//        return student;
        return studentRepository.getStudent(regNo);
    }

    public String addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public String updateAge(int regNo, int age) {
        return studentRepository.updateAge(regNo, age);
    }

    public String deleteStudent(int regNo) {
        return studentRepository.deleteStudent(regNo);
    }

    public String updateCourse(int regNo, String course) {
        return studentRepository.updateCourse(regNo, course);
    }

    public String updateCourseParamBody(Student student, String course) {
        return studentRepository.updateCourseParamBody(student, course);
    }
}
