package com.practice.springboot.project1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootProject1ApplicationTests {

	@Autowired
	StudentService studentService;

	@BeforeEach
	public void prepare() {
		studentService.addStudent(new Student(1, "dummy1" , 24, "CSE"));
		studentService.addStudent(new Student(2, "dummy2" , 25, "CHE"));
		studentService.addStudent(new Student(3, "dummy3" , 26, "IT"));
	}

	@Test
	public void addStudentTest() {
		Student student = new Student(1, "dummy" , 24, "CSE");
		studentService.addStudent(student);

		Student expectedOutput = new Student(1, "dummy" , 24 , "CSE");
		Student actualOutput = studentService.getStudent(1);

		Assertions.assertEquals(expectedOutput.getRegNo(), actualOutput.getRegNo());
		Assertions.assertEquals(expectedOutput.getAge(), actualOutput.getAge());
		Assertions.assertEquals(expectedOutput.getName(), actualOutput.getName());
		Assertions.assertEquals(expectedOutput.getCourse(), actualOutput.getCourse());
	}

	@Test
	public void getStudentTest() {
		Student expectedOutput = new Student(2, "dummy2" , 25, "CHE");
		Student actualOutput = studentService.getStudent(2);

		Assertions.assertEquals(expectedOutput.getRegNo(), actualOutput.getRegNo());
		Assertions.assertEquals(expectedOutput.getName(), actualOutput.getName());
		Assertions.assertEquals(expectedOutput.getAge(), actualOutput.getAge());
		Assertions.assertEquals(expectedOutput.getCourse(), actualOutput.getCourse());
	}

	@Test
	void contextLoads() {
	}

}
