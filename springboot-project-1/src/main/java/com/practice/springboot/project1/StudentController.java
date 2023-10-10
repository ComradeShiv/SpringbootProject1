package com.practice.springboot.project1;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    Map<Integer, Student> db = new HashMap<>();
    @GetMapping("/get")
    public Student getStudent(@RequestParam("id") int regNo) {
        if(db.containsKey(regNo)) {
            return db.get(regNo);
        }
        return null;
    }
    // if this was a hotstar API: https://hotstar.com/get

    @PostMapping("/add")
    public String addStudent(@RequestBody() Student student) {
        db.put(student.getRegNo(), student);
        return "Student has been added successfully";
    }

    @GetMapping("/getByPath/{id}")
    public Student getStudentUsingPath(@PathVariable("id") int regNo) {
        if(db.containsKey(regNo)) {
            return db.get(regNo);
        }
        return null;
    }

    @PutMapping("/update-age/{id}")
    public String updateAge(@PathVariable("id") int regNo, @RequestParam("age") int age) {
        db.get(regNo).setAge(age);
        return "Age has been updated successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentUsingPath(@PathVariable("id") int regNo) {
        if(db.containsKey(regNo)) {
            db.remove(regNo);
            return "Student data deleted successfully";
        }
        return "Student not found !!";
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("id") int regNo) {
        if(db.containsKey(regNo)) {
            db.remove(regNo);
            return "Student data deleted successfully";
        }
        return "Student not found";
    }

    @PutMapping("/update-course")
    public String updateCourse(@RequestParam("id") int regNo, @RequestParam("course") String course) {
        if(db.containsKey(regNo)) {
            db.get(regNo).setCourse(course);
            return "Course has been updated successfully";
        }
        return "Student not found !!";
    }

    @PutMapping("/update-course/{id}/{course}")
    public String updateCourseUsingPath(@PathVariable("id") int regNo, @PathVariable("course") String course) {
        if(db.containsKey(regNo)) {
            db.get(regNo).setCourse(course);
            return "Course has been successfully";
        }
        return "Student not found";
    }

    @PutMapping("/update-course/{course}")
    public String updateCourseParamPath(@RequestParam("id") int regNo, @PathVariable("course") String course) {
        if(db.containsKey(regNo)) {
            db.get(regNo).setCourse(course);
            return "Course has been successfully";
        }
        return "Student not found";
    }

    @PutMapping("/update")
    public String updateCourseParamBody(@RequestBody() Student student, @RequestParam("course") String course) {
        if(db.containsKey(student.getRegNo())) {
            student.setCourse(course);
            return "Course has been successfully";
        }
        return "Student not found";
    }
}
