package com.project.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.school.entities.Student;



public interface StudentRepo extends JpaRepository<Student,Integer>{

}