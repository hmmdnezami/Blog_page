package com.project.school.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.payloads.ApiResponse;
import com.project.school.payloads.StudentDto;
import com.project.school.services.StudentService;



@RestController
@RequestMapping("/eschool/student/")
public class StudentController {
	@Autowired
	private StudentService studentService; 
	
	@PostMapping("/") 
	public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
		StudentDto createStudentDto = this.studentService.createStudent(studentDto);
		return new ResponseEntity<>(createStudentDto, HttpStatus.CREATED);
	}
	
	@PutMapping("/{studentId}")
	public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto, @PathVariable("studentId") Integer sid) {
		StudentDto updatedStudent = this.studentService.updateStudent(studentDto, sid);
		return ResponseEntity.ok(updatedStudent);
	}
	
	@DeleteMapping("/{studentId}")
	public ResponseEntity<ApiResponse> deleteStudent(@PathVariable("studentId") Integer sid) {
		this.studentService.deleteStudent(sid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Student deleted Successfully", true), HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<StudentDto>> getAllStudents() {
		return ResponseEntity.ok(this.studentService.getAllStudents());
	}
	
	@GetMapping("/{studentId}")
	public ResponseEntity<StudentDto> getSingleStudent(@PathVariable Integer studentId) {
		return ResponseEntity.ok(this.studentService.getStudentById(studentId));
	}
}
