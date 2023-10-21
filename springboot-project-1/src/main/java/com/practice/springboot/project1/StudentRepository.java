package com.practice.springboot.project1;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {

    Map<Integer, Student> db = new HashMap<>();

    public Student getStudent(int regNo) {
        if(db.containsKey(regNo)) {
            return db.get(regNo);
        }
        return null;
    }

    public String addStudent(Student student) {
        db.put(student.getRegNo(), student);
        return "Student has been added successfully";
    }

    public String updateAge(int regNo, int age) {
        db.get(regNo).setAge(age);
        return "Age has been updated successfully";
    }

    public String deleteStudent(int regNo) {
        if(db.containsKey(regNo)) {
            db.remove(regNo);
            return "Student data deleted successfully";
        }
        return "Student not found";
    }

    public String updateCourse(int regNo, String course) {
        if(db.containsKey(regNo)) {
            db.get(regNo).setCourse(course);
            return "Course has been updated successfully";
        }
        return "Student not found !!";
    }

    public String updateCourseParamBody(Student student, String course) {
        if(db.containsKey(student.getRegNo())) {
            student.setCourse(course);
            return "Course has been successfully";
        }
        return "Student not found";
    }
}
