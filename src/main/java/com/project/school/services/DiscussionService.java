package com.project.school.services;

import java.util.List;

import com.project.school.payloads.DiscussionDto;



public interface DiscussionService {
	DiscussionDto createDiscussion(DiscussionDto discusstionDto, Integer teacherId);

	DiscussionDto updateDiscussion(DiscussionDto discussionDto, Integer discussionId);

	DiscussionDto getDiscussionById(Integer discussionId);

	List<DiscussionDto> getAllDiscussions();

	void deleteDiscussion(Integer discussionId);
	
	List<DiscussionDto> getDiscussionsByTeacher(Integer teacherId) ;
	
	List<DiscussionDto> getDiscussionByStudent (Integer studentId) ;
}
