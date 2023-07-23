package com.project.school.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.entities.Teacher;
import com.project.school.entities.Test;
import com.project.school.exceptions.ResourceNotFoundException;
import com.project.school.payloads.TestDto;
import com.project.school.repositories.TeacherRepo;
import com.project.school.repositories.TestRepo;
import com.project.school.services.TestService;

@Service
public class TestServiceImpl implements TestService{
	
	@Autowired
	private TestRepo testRepo ; 
	
	@Autowired
	private ModelMapper modelMapper ; 
	
	
	@Autowired
	private TeacherRepo teacherRepo ; 

	@Override
	public TestDto createTest(TestDto testDto, Integer teacherId) {
		
		Teacher teacher = this.teacherRepo.findById(teacherId).orElseThrow(() -> new ResourceNotFoundException("Teacher", " Id ", teacherId)) ; 	
		System.out.println(teacher);
		Test test = this.modelMapper.map(testDto, Test.class); 		
		test.setTeacher(teacher) ;
		Test test1 = this.testRepo.save(test) ;
		
		return this.modelMapper.map(test1, TestDto.class); 
	}

	@Override
	public TestDto updateTest(TestDto testDto, Integer testId) {
		
		Test test = this.testRepo.findById(testId).orElseThrow(() -> new ResourceNotFoundException("Discussion", " Id ", testId)) ; 
		
		test.setSubject(testDto.getSubject());
		Test discussion1 = this.testRepo.save(test) ;
		
		return this.modelMapper.map(discussion1, TestDto.class); 
	}

	@Override
	public TestDto getTestById(Integer testId) {
		Test test = this.testRepo.findById(testId).orElseThrow(() -> new ResourceNotFoundException("Test", " Id ", testId)) ; 
		return this.modelMapper.map(test, TestDto.class); 
	}

	@Override
	public List<TestDto> getAllTests() {
		List<Test> tests = this.testRepo.findAll();
		List<TestDto> testDtos = tests.stream().map(test -> this.modelMapper.map(test, TestDto.class)).collect(Collectors.toList());
		return testDtos;
	} 

	@Override
	public void deleteTest(Integer testId) {
		Test test = this.testRepo.findById(testId).orElseThrow(() -> new ResourceNotFoundException("Test", " Id ", testId)) ; 
		this.testRepo.delete(test); 
	}

	@Override
	public List<TestDto> getTestsByTeacher(Integer teacherId) {
		Teacher teacher = this.teacherRepo.findById(teacherId).orElseThrow(() -> new ResourceNotFoundException ("Teacher" , "ID ", teacherId)); 
		
		List<Test> tests = this.testRepo.findByTeacher(teacher) ;
		List<TestDto> testDtos = tests.stream().map(test -> this.modelMapper.map(test, TestDto.class)).collect(Collectors.toList());
		return testDtos;
	}

}
