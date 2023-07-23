package com.project.school.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.school.entities.Discussion;
import com.project.school.entities.Student;
import com.project.school.entities.Teacher;
import com.project.school.exceptions.ResourceNotFoundException;
import com.project.school.payloads.DiscussionDto;
import com.project.school.payloads.StudentDto;
import com.project.school.repositories.DiscussionRepo;
import com.project.school.repositories.StudentRepo;
import com.project.school.repositories.TeacherRepo;
import com.project.school.services.DiscussionService;

@Service
public class DiscussionServiceImpl implements DiscussionService {
	
	@Autowired
	private DiscussionRepo discussionRepo ; 
	
	@Autowired
	private ModelMapper modelMapper ; 
	
	@Autowired
	private StudentRepo studentRepo ;
	
	@Autowired
	private TeacherRepo teacherRepo ; 

	@Override
	public DiscussionDto createDiscussion(DiscussionDto discusstionDto, Integer teacherId) {
		
		Teacher teacher = this.teacherRepo.findById(teacherId).orElseThrow(() -> new ResourceNotFoundException("Teacher", " Id ", teacherId)) ; 	
		Discussion discussion = this.modelMapper.map(discusstionDto, Discussion.class); 		
		discussion.setTeacher(teacher) ;
		Discussion discussion1 = this.discussionRepo.save(discussion) ;
		
		return this.modelMapper.map(discussion1, DiscussionDto.class); 
	}

	@Override
	public DiscussionDto updateDiscussion(DiscussionDto discussionDto, Integer discussionId) {
		
		Discussion discussion = this.discussionRepo.findById(discussionId).orElseThrow(() -> new ResourceNotFoundException("Discussion", " Id ", discussionId)) ; 
		
		discussion.setSubject(discussionDto.getSubject());
		Discussion discussion1 = this.discussionRepo.save(discussion) ;
		
		return this.modelMapper.map(discussion1, DiscussionDto.class); 
	}

	@Override
	public DiscussionDto getDiscussionById(Integer discussionId) {
		Discussion discussion = this.discussionRepo.findById(discussionId).orElseThrow(() -> new ResourceNotFoundException("Discussion", " Id ", discussionId)) ; 
		return this.modelMapper.map(discussion, DiscussionDto.class); 
	}

	@Override
	public List<DiscussionDto> getAllDiscussions() {
		List<Discussion> discussions = this.discussionRepo.findAll();
		List<DiscussionDto> discussionDtos = discussions.stream().map(discussion -> this.modelMapper.map(discussion, DiscussionDto.class)).collect(Collectors.toList());
		return discussionDtos;
	} 

	@Override
	public void deleteDiscussion(Integer discussionId) {
		Discussion discussion = this.discussionRepo.findById(discussionId).orElseThrow(() -> new ResourceNotFoundException("Discussion", " Id ", discussionId)) ; 
		this.discussionRepo.delete(discussion); 
	}

	@Override
	public List<DiscussionDto> getDiscussionsByTeacher(Integer teacherId) {
		Teacher teacher = this.teacherRepo.findById(teacherId).orElseThrow(() -> new ResourceNotFoundException ("Teacher" , "ID ", teacherId)); 
		
		List<Discussion> discussions = this.discussionRepo.findByTeacher(teacher) ;
		List<DiscussionDto> discussionDtos = discussions.stream().map(discussion -> this.modelMapper.map(discussion, DiscussionDto.class)).collect(Collectors.toList());
		return discussionDtos;
	}

	@Override
	public List<DiscussionDto> getDiscussionByStudent(Integer studentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
