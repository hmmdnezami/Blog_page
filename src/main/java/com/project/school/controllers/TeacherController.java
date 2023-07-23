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
import com.project.school.payloads.TeacherDto;
import com.project.school.services.TeacherService;

@RestController
@RequestMapping("/eschool/teacher/")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService; 
	
	@PostMapping("/") 
	public ResponseEntity<TeacherDto> createTeacher(@RequestBody TeacherDto teacherDto) {
		TeacherDto createTeacherDto = this.teacherService.createTeacher(teacherDto);
		return new ResponseEntity<>(createTeacherDto, HttpStatus.CREATED);
	}
	
	@PutMapping("/{teacherId}")
	public ResponseEntity<TeacherDto> updateTeacher(@RequestBody TeacherDto teacherDto, @PathVariable("teacherId") Integer tid) {
		TeacherDto updatedTeacher = this.teacherService.updateTeacher(teacherDto, tid);
		return ResponseEntity.ok(updatedTeacher);
	}
	
	@DeleteMapping("/{teacherId}")
	public ResponseEntity<ApiResponse> deleteTeacher(@PathVariable("teacherId") Integer tid) {
		this.teacherService.deleteTeacher(tid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Teacher deleted Successfully", true), HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<TeacherDto>> getAllTeachers() {
		return ResponseEntity.ok(this.teacherService.getAllTeachers());
	}
	
	@GetMapping("/{teacherId}")
	public ResponseEntity<TeacherDto> getSingleTeacher(@PathVariable Integer teacherId) {
		return ResponseEntity.ok(this.teacherService.getTeacherById(teacherId));
	}

}
