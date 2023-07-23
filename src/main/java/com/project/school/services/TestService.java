package com.project.school.services;

import java.util.List;

import com.project.school.payloads.TestDto;



public interface TestService {
	
	TestDto createTest(TestDto testDto, Integer teacherId);

	TestDto updateTest(TestDto testDto, Integer testId);

	TestDto getTestById(Integer testId);

	List<TestDto> getAllTests();

	void deleteTest(Integer testId);
	
	List<TestDto> getTestsByTeacher(Integer teacherId) ;
	
}
