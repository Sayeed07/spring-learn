package com.sayeed.service;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sayeed.dto.CheckPhotoDTO;
import com.sayeed.dto.StudentDTO;
import com.sayeed.dto.TeacherDTO;
import com.sayeed.model.entity.CheckPhoto;
import com.sayeed.model.entity.Student;
import com.sayeed.model.entity.Teacher;
import com.sayeed.model.repository.CheckPhotoRepository;
import com.sayeed.model.repository.StudentRepository;
import com.sayeed.model.repository.TeacherRepository;


@Service
@Transactional
public class RegistrationService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private CheckPhotoRepository checkPhotoRepository;
	
	
	// Teacher CRUD start
	public void saveTeacher(TeacherDTO teacherDTO) {
		teacherRepository.save(copyTeacherDTOtoTeacher(teacherDTO));
	}
	
	public List<TeacherDTO> findAllTeacher(){
		List<Teacher> teachers = teacherRepository.findAll();
		List<TeacherDTO> teacherDTOs = new ArrayList<>();
		
		for(Teacher teacher : teachers) {
			teacherDTOs.add(copyTeachertoTeacherDTO(teacher));
		}
		
		return teacherDTOs;
	}
	
	public TeacherDTO findTeacherById(Long teacherId) {
		return copyTeachertoTeacherDTO(teacherRepository.findOne(teacherId));
	}
	
	public boolean deleteTeacherById(Long teacherId) {
		teacherRepository.delete(teacherId);
		return true;
	}
	
	// Teacher CRUD end
	
	
	
	// Student CRUD start
	
	public void saveStudent(StudentDTO studentDTO) {
		studentRepository.save(copyStudentDTOtoStudent(studentDTO));
	}
	
	public Teacher makeTeacherObject(Long teacherId) {
		Teacher teacher = new Teacher();
		teacher.setTeacherId(teacherId);
		return teacher;
	}
	
	public List<StudentDTO> findAllStudent(){
		List<Student> students = studentRepository.findAll();
		List<StudentDTO> studentDTOs = new ArrayList<>();
		
		for(Student student : students) {
			studentDTOs.add(copyStudenttoStudentDTO(student));
		}
		
		return studentDTOs;
	}
	
	public StudentDTO findStudentById(Long studentId) {
		return copyStudenttoStudentDTO(studentRepository.findOne(studentId));
	}
	
	public void deleteStudentById(long studentId) {
		studentRepository.delete(studentId);	
	}
	
	// Student CRUD end
	
	//Photo CRUD start
	
	public String writePhoto(MultipartFile photo, Long val) {
		
		try {
			Files.write(Paths.get("E:/images"+File.separator+val+".custom"+photo.getOriginalFilename()), photo.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return val+".custom"+photo.getOriginalFilename();
	}
	
	public void savePhoto(CheckPhotoDTO checkPhotoDTO, MultipartFile photo) {
		CheckPhoto checkPhoto = new CheckPhoto();
		List<CheckPhoto> checkPhotos = checkPhotoRepository.findAll();
		Long maxCheckPhotosId = checkPhotos.get(checkPhotos.size()-1).getProductId();
		maxCheckPhotosId++;
		checkPhotoDTO.setImageName(writePhoto(photo,maxCheckPhotosId));
		BeanUtils.copyProperties(checkPhotoDTO, checkPhoto);
		checkPhotoRepository.save(checkPhoto);
	}
	
	public void updatePhoto(CheckPhotoDTO checkPhotoDTO,MultipartFile photo) {
		CheckPhoto checkPhoto = new CheckPhoto();
		Long maxCheckPhotosId = checkPhotoDTO.getProductId();
		checkPhotoDTO.setImageName(writePhoto(photo,maxCheckPhotosId));
		BeanUtils.copyProperties(checkPhotoDTO, checkPhoto);
		checkPhotoRepository.save(checkPhoto);
	}
	
	
	public List<CheckPhotoDTO> findAllPhoto(){
		List<CheckPhotoDTO> checkPhotoDTOs = new ArrayList<>();
		List<CheckPhoto> checkPhotos = checkPhotoRepository.findAll();
		
		for(CheckPhoto checkPhoto : checkPhotos) {
			CheckPhotoDTO checkPhotoDTO = new CheckPhotoDTO();
			BeanUtils.copyProperties(checkPhoto, checkPhotoDTO);
			checkPhotoDTOs.add(checkPhotoDTO);
		}
		
		return checkPhotoDTOs;
	}
	
	public void deletePhotodataById(Long productId) {
		checkPhotoRepository.delete(productId);
	}
	
	public CheckPhotoDTO findPhotodataById(Long productId) {
		CheckPhotoDTO checkPhotoDTO = new CheckPhotoDTO();
		CheckPhoto checkPhoto = checkPhotoRepository.findOne(productId);
		BeanUtils.copyProperties(checkPhoto, checkPhotoDTO);
		return checkPhotoDTO;
	}
	
	
	public DefaultCategoryDataset findBarChartByProductTitle(CheckPhotoDTO checkPhotoDTO) {
		
		List<CheckPhoto> checkPhotos = checkPhotoRepository.findByProductTitle(checkPhotoDTO.getProductTitle());
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for(CheckPhoto checkPhoto : checkPhotos) {
			dataset.addValue(checkPhoto.getProductPrice(), "values", checkPhoto.getProductId());
		}
		
		return dataset;
	}
	
	public JFreeChart createBarChart(CheckPhotoDTO checkPhotoDTO) {
		JFreeChart chart = 
	ChartFactory.createBarChart(checkPhotoDTO.getProductTitle(), "Days", "Product Price", findBarChartByProductTitle(checkPhotoDTO),
				PlotOrientation.VERTICAL, true, true, true);
		return chart;
	}
	
	
	
	//Photo CRUD end
	
	
	//Copy methods starts
	
	public Teacher copyTeacherDTOtoTeacher(TeacherDTO teacherDTO) {
		Teacher teacher = new Teacher();
		BeanUtils.copyProperties(teacherDTO, teacher);
		return teacher;
	}
	
	public TeacherDTO copyTeachertoTeacherDTO(Teacher teacher) {
		TeacherDTO teacherDTO = new TeacherDTO();
		BeanUtils.copyProperties(teacher, teacherDTO);
		return teacherDTO;
	}
	
	
	public Student copyStudentDTOtoStudent(StudentDTO studentDTO) {
		Student student = new Student();
		BeanUtils.copyProperties(studentDTO, student);
		student.setTeacher(makeTeacherObject(studentDTO.getTeacherId()));
		return student;
	}
	
	public StudentDTO copyStudenttoStudentDTO(Student student) {
		StudentDTO studentDTO = new StudentDTO();
		BeanUtils.copyProperties(student, studentDTO);
		return studentDTO;
	}
	
	//Copy methods end
	
}
