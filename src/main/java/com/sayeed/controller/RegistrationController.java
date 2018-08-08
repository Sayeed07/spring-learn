package com.sayeed.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

import org.jfree.chart.ChartUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sayeed.dto.CheckPhotoDTO;
import com.sayeed.dto.StudentDTO;
import com.sayeed.dto.TeacherDTO;
import com.sayeed.dto.TestDTO;
import com.sayeed.service.RegistrationService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
	
	@Autowired
	RegistrationService registrationService;
	
	// Country,city,state test check
	
	@RequestMapping(value="/test",method=RequestMethod.POST)
	public String testCountryCityState(TestDTO testDTO,Model model) {
		System.out.println("District : "+testDTO.getDistrict()+" Thana : "+testDTO.getThana());
		model.addAttribute("message","Test data has been saved successfully!");
		return "test";
	}
	
	//Teacher start
	@RequestMapping(value="/teacher/save",method=RequestMethod.POST)
	public String sveAndUpdateTeacher(TeacherDTO teacherDTO,Model model) {
		registrationService.saveTeacher(teacherDTO);
		model.addAttribute("message","Data has been saved successfully!");
		return "teacherSignup";
	}
	
	@RequestMapping(value="/teacher/find-all",method=RequestMethod.GET)
	public String findallTeaacher(Model model)
	{
		model.addAttribute("teachers",registrationService.findAllTeacher());
		return "index";
	}
	
	@RequestMapping(value="/teacher/edit",method=RequestMethod.GET)
	public String findTeaacherById(@RequestParam Long teacherId,Model model)
	{
		model.addAttribute("teacher",registrationService.findTeacherById(teacherId));
		return "teacherSignup";
	}
	
	@RequestMapping(value="/teacher/delete",method=RequestMethod.GET)
	public String deleteTeaacherById(@RequestParam Long teacherId,Model model)
	{
		registrationService.deleteTeacherById(teacherId);
		model.addAttribute("teachers",registrationService.findAllTeacher());
		return "index";
	}
	
	@RequestMapping(value="/student/studentSignup",method=RequestMethod.GET)
	public String studentSignup(Model model) {
		model.addAttribute("teachers",registrationService.findAllTeacher());
		System.out.println("Hell");
		return "studentSignup";
	}
	
	//Teacher end
	
	//Student start
	
	@RequestMapping(value="/student/save-or-update",method=RequestMethod.POST)
	public String saveOrUpdateTeacher(StudentDTO studentDTO,Model model) {
		registrationService.saveStudent(studentDTO);
		model.addAttribute("message", "Data inserted into student table successfully !!");
		return "studentSignup";
	}
	
	
	@RequestMapping(value="/student/find-all",method=RequestMethod.GET)
	public String findAllStudent(StudentDTO studentDTO,Model model) {
		model.addAttribute("students", registrationService.findAllStudent());
		return "index";
	}
	
	
	@RequestMapping(value="/student/edit",method=RequestMethod.GET)
	public String editStudentById(@RequestParam Long studentId,Model model) {
		model.addAttribute("student", registrationService.findStudentById(studentId));
		model.addAttribute("teachers",registrationService.findAllTeacher());
		return "studentSignup";
	}
	
	@RequestMapping(value="/student/delete",method=RequestMethod.GET)
	public String deleteStudentById(@RequestParam Long studentId,Model model) {
		registrationService.deleteStudentById(studentId);
		model.addAttribute("students", registrationService.findAllStudent());
		return "index";
	}
	
	//Student end
	
	//Photo Upload Start
	@RequestMapping(value="/photo/save" ,method=RequestMethod.POST)
	public String savePhoto(CheckPhotoDTO checkPhotoDTO, MultipartFile photo ,Model model) {
		
		if( Objects.equals(checkPhotoDTO.getProductId(), null) || Objects.equals(checkPhotoDTO.getProductId(), 0L) ) {
			registrationService.savePhoto(checkPhotoDTO, photo);
		}
		else {
			registrationService.updatePhoto(checkPhotoDTO, photo);
		}
		
		model.addAttribute("message","Data and photo has updated successfully");
		
		return "uploadImage";
	}
	
	@RequestMapping(value="/photo/find-all" ,method=RequestMethod.GET)
	public String findAllPhotoData(Model model) {
		model.addAttribute("photoDatas", registrationService.findAllPhoto());
		return "index";
	}
	
	@RequestMapping(value="/photo/edit" ,method=RequestMethod.GET)
	public String findPhotoDataById(@RequestParam Long productId, Model model) {
		model.addAttribute("updatePhotoData", registrationService.findPhotodataById(productId));
		return "uploadImage";
	}
	
	
	@RequestMapping(value="/photo/delete" ,method=RequestMethod.GET)
	public String deletePhotoDataById(@RequestParam Long productId, Model model) {
		registrationService.deletePhotodataById(productId);
		model.addAttribute("photoDatas", registrationService.findAllPhoto());
		return "index";
	}
	
	
	@RequestMapping(value="/photo/searchPrice" ,method=RequestMethod.POST)
	public String findBarChartByProductTitle(CheckPhotoDTO checkPhotoDTO,Model model) {
		
		try {
			Files.write(Paths.get("E:/images/" + File.separator + "my_chart_pie.jpg"), ChartUtilities.encodeAsPNG(registrationService
					.createBarChart(checkPhotoDTO).createBufferedImage(600, 200)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("imageName", "my_chart_pie.jpg");
		
		return "index";
		
	}
	//Photo Upload End
	
	
}
