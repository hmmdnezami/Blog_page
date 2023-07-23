package com.project.school.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.school.entities.Teacher;
import com.project.school.entities.Test;

public interface TestRepo extends JpaRepository<Test, Integer> {
	List<Test> findByTeacher(Teacher teacher) ; 
}
