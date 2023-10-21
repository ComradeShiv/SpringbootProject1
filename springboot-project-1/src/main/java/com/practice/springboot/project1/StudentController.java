package com.practice.springboot.project1;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.logging.Logger;

@RestController
@RequestMapping("/Student")
@Slf4j
public class StudentController {

    @Autowired
    StudentService studentService;

//    public Logger log = Logger.getLogger(String.valueOf(StudentController.class));

    @GetMapping("/get")
    public ResponseEntity getStudent(@RequestParam("id") int regNo) {
        Student student = studentService.getStudent(regNo);
        if(student == null) {
            return new ResponseEntity<>("It doesn't exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(student, HttpStatus.FOUND);
    }
    // if this was a hotstar API: https://hotstar.com/Student/get

    @PostMapping("/add")
    public String addStudent(@RequestBody() Student student) {
        log.trace("This is a TRACE log");
        log.debug("This is a DEBUG log");
        log.info("This is a INFO log");
        log.warn("This is a WARN log");
        log.error("This is a ERROR log");

        return studentService.addStudent(student);
    }

    @GetMapping("/getByPath/{id}")
    public ResponseEntity getStudentUsingPath(@PathVariable("id") int regNo) {
        Student student = studentService.getStudent(regNo);
        if(student == null) {
            return new ResponseEntity<>("It doesn't exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(student, HttpStatus.FOUND);
    }

    @PutMapping("/update-age/{id}")
    public String updateAge(@PathVariable("id") int regNo, @RequestParam("age") int age) {
        return studentService.updateAge(regNo, age);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentUsingPath(@PathVariable("id") int regNo) {
        return studentService.deleteStudent(regNo);
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("id") int regNo) {
        return studentService.deleteStudent(regNo);
    }

    @PutMapping("/update-course")
    public String updateCourse(@RequestParam("id") int regNo, @RequestParam("course") String course) {
        return studentService.updateCourse(regNo, course);
    }

    @PutMapping("/update-course/{id}/{course}")
    public String updateCourseUsingPath(@PathVariable("id") int regNo, @PathVariable("course") String course) {
        return studentService.updateCourse(regNo, course);
    }

    @PutMapping("/update-course/{course}")
    public String updateCourseParamPath(@RequestParam("id") int regNo, @PathVariable("course") String course) {
        return studentService.updateCourse(regNo, course);
    }

    @PutMapping("/update")
    public String updateCourseParamBody(@RequestBody() Student student, @RequestParam("course") String course) {
        return studentService.updateCourseParamBody(student, course);
    }
}
