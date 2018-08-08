package com.sayeed.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sayeed.model.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
