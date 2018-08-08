package com.sayeed.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="teacher_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teacherId;
	
	@Column(name="teacher_name")
	private String teacherName;
	
	@Column(name="department")
	private String department;
	
	
	public Long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
}
