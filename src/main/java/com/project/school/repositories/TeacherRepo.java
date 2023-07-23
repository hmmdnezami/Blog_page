package com.project.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.school.entities.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher,Integer>{

}
