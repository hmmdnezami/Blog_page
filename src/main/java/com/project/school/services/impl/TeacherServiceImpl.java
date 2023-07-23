package com.project.school.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.entities.Teacher;
import com.project.school.exceptions.ResourceNotFoundException;
import com.project.school.payloads.TeacherDto;
import com.project.school.repositories.TeacherRepo;
import com.project.school.services.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherRepo teacherRepo ; 
	
	@Autowired
	private ModelMapper modelMapper ;

	@Override
	public TeacherDto createTeacher(TeacherDto teacherDto) {
		Teacher teacher = this.dtoToTeacher(teacherDto) ;
		Teacher savedTeacher = this.teacherRepo.save(teacher);
		return this.teacherToDto(savedTeacher); 
	}

	@Override
	public TeacherDto updateTeacher(TeacherDto teacherDto, Integer teacherId) {
		Teacher teacher = this.teacherRepo.findById(teacherId)
				.orElseThrow(() -> new ResourceNotFoundException("Teacher", " Id ", teacherId));

		teacher.setName(teacherDto.getName());
		teacher.setEmail(teacherDto.getEmail());
		teacher.setAddress(teacherDto.getAddress());
		teacher.setMobile_number(teacherDto.getMobile_number());

		Teacher updatedTeacher = this.teacherRepo.save(teacher);
		TeacherDto TeacherDto1 = this.teacherToDto(updatedTeacher);
		return TeacherDto1;
	}

	@Override
	public TeacherDto getTeacherById(Integer teacherId) {
		Teacher teacher = this.teacherRepo.findById(teacherId)
				.orElseThrow(() -> new ResourceNotFoundException("Teacher", " Id ", teacherId));
		return this.teacherToDto(teacher);
	}

	@Override
	public List<TeacherDto> getAllTeachers() {
		List<Teacher> teachers = this.teacherRepo.findAll();
		List<TeacherDto> teacherDtos = teachers.stream().map(teacher -> this.teacherToDto(teacher)).collect(Collectors.toList());
		return teacherDtos;
	}

	@Override
	public void deleteTeacher(Integer teacherId) {
		Teacher teacher = this.teacherRepo.findById(teacherId)
				.orElseThrow(() -> new ResourceNotFoundException("Teacher", " Id ", teacherId));
		this.teacherRepo.delete(teacher);
	}
	
	public Teacher dtoToTeacher(TeacherDto teacherDto) {
		Teacher teacher = this.modelMapper.map(teacherDto, Teacher.class);
		return teacher;
	}
	
	public TeacherDto teacherToDto(Teacher teacher) {
		TeacherDto teacherDto = this.modelMapper.map(teacher, TeacherDto.class);
		return teacherDto;
	}

}
