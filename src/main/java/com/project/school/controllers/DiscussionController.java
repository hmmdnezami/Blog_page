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

import com.project.school.payloads.DiscussionDto;
import com.project.school.services.DiscussionService;

@RestController
@RequestMapping("/eschool/discussion")
public class DiscussionController {
	
	@Autowired
	private DiscussionService discussionService ;
	
	@PostMapping("/{teacherId}")
	public ResponseEntity<DiscussionDto> createDiscussion(@RequestBody DiscussionDto discussionDto, @PathVariable Integer teacherId) {
		DiscussionDto createDiscussion = this.discussionService.createDiscussion(discussionDto, teacherId) ; 	
		return new ResponseEntity<DiscussionDto>(createDiscussion , HttpStatus.CREATED);
	}
	
	@PutMapping("/{teacherId}")
	public ResponseEntity<DiscussionDto> updateDiscussion(@RequestBody DiscussionDto discussionDto ,@PathVariable Integer teacherId) {
		
		DiscussionDto updateDiscussion = this.discussionService.updateDiscussion(discussionDto, teacherId) ; 
		return new ResponseEntity<DiscussionDto>(updateDiscussion , HttpStatus.OK) ; 
	}

	@GetMapping("/")
	public ResponseEntity<List<DiscussionDto>> getAllDiscussions() {
		return ResponseEntity.ok(this.discussionService.getAllDiscussions());
	}
	
	@GetMapping("/{discussionId}")
	public ResponseEntity<DiscussionDto> getDiscussionById(@PathVariable Integer discussionId) {
		return ResponseEntity.ok(this.discussionService.getDiscussionById(discussionId));
	}
	
	@GetMapping("/{teacherId}")
	public ResponseEntity<List<DiscussionDto>> getDiscussionsByTeacher(@PathVariable Integer teacherId) {
		
		List<DiscussionDto> lists = this.discussionService.getDiscussionsByTeacher(teacherId) ;
		
		return new ResponseEntity<List<DiscussionDto>> (lists, HttpStatus.OK); 
	}
	
	
	
}
