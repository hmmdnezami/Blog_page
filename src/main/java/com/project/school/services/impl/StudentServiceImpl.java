package com.project.school.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.entities.Student;
import com.project.school.exceptions.ResourceNotFoundException;
import com.project.school.payloads.StudentDto;
import com.project.school.repositories.StudentRepo;
import com.project.school.services.StudentService;


@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepo studentRepo ; 
	
	@Autowired
	private ModelMapper modelMapper ;

	@Override
	public StudentDto createStudent(StudentDto studentDto) {
		Student student = this.dtoToStudent(studentDto) ;
		Student savedStudent = this.studentRepo.save(student);
		return this.studentToDto(savedStudent); 
	}

	@Override
	public StudentDto updateStudent(StudentDto studentDto, Integer studentId) {
		Student student = this.studentRepo.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student", " Id ", studentId));

		student.setName(studentDto.getName());
		student.setEmail(studentDto.getEmail());
		student.setAddress(studentDto.getAddress());
		student.setMobile_number(studentDto.getMobile_number());

		Student updatedStudent = this.studentRepo.save(student);
		StudentDto StudentDto1 = this.studentToDto(updatedStudent);
		return StudentDto1;
	}

	@Override
	public StudentDto getStudentById(Integer studentId) {
		Student teacher = this.studentRepo.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Teacher", " Id ", studentId));
		return this.studentToDto(teacher);
	}

	@Override
	public List<StudentDto> getAllStudents() {
		List<Student> students = this.studentRepo.findAll();
		List<StudentDto> studentDtos = students.stream().map(student -> this.studentToDto(student)).collect(Collectors.toList());
		return studentDtos;
	}

	@Override
	public void deleteStudent(Integer studentId) {
		Student student = this.studentRepo.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("student", " Id ", studentId));
		this.studentRepo.delete(student);
	}
	
	public Student dtoToStudent(StudentDto studentDto) {
		Student student = this.modelMapper.map(studentDto, Student.class);
		return student;
	}
	
	public StudentDto studentToDto(Student student) {
		StudentDto studentDto = this.modelMapper.map(student, StudentDto.class);
		return studentDto;
	}
}
