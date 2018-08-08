package com.sayeed.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sayeed.model.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
