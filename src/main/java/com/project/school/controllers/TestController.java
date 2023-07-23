package com.project.school.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.school.payloads.TestDto;
import com.project.school.services.TestService;



@RestController
@RequestMapping("/eschool/test")
public class TestController {
	
	@Autowired
	private TestService testService ;
	
	@PostMapping("/{teacherId}")
	public ResponseEntity<TestDto> createTest(@RequestBody TestDto testDto, @PathVariable Integer teacherId) {
		TestDto createTest = this.testService.createTest(testDto, teacherId) ; 	
		return new ResponseEntity<TestDto>(createTest , HttpStatus.CREATED);
	}
	
	@PutMapping("/{teacherId}")
	public ResponseEntity<TestDto> updateTest(@RequestBody TestDto testDto ,@PathVariable Integer teacherId) {
		
		TestDto updateTest = this.testService.updateTest(testDto, teacherId) ; 
		return new ResponseEntity<TestDto>(updateTest , HttpStatus.OK) ; 
	}

	@GetMapping("/")
	public ResponseEntity<List<TestDto>> getAllTests() {
		return ResponseEntity.ok(this.testService.getAllTests());
	}
	
	@GetMapping("/{testId}")
	public ResponseEntity<TestDto> getTestById(@PathVariable Integer testId) {
		return ResponseEntity.ok(this.testService.getTestById(testId));
	}
	
	@GetMapping("/teacher/{teacherId}")
	public ResponseEntity<List<TestDto>> getTestsByTeacher(@PathVariable Integer teacherId) {
		
		List<TestDto> lists = this.testService.getTestsByTeacher(teacherId) ;
		
		return new ResponseEntity<List<TestDto>> (lists, HttpStatus.OK); 
	}
	
	
	
}
