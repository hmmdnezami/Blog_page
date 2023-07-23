package com.project.school.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.school.entities.Discussion;
import com.project.school.entities.Teacher;

public interface DiscussionRepo extends JpaRepository<Discussion, Integer> {

	List<Discussion> findByTeacher(Teacher teacher) ; 
}
