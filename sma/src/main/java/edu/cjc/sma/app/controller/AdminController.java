package edu.cjc.sma.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cjc.sma.app.model.Student;
import edu.cjc.sma.app.servicei.StudentServiceI;

@Controller
public class AdminController {
	@Autowired
	StudentServiceI ssi;

	@RequestMapping("/")
	public String preLogin() {
		return "login";
	}
	
	@RequestMapping("/login")
	public String loginStudent(@RequestParam("username") String username,@RequestParam("password") String password,Model m) {
		
		 if(username.equals("Admin") && password.equals("Admin"))
		 {
			 List<Student> list=ssi.getAllStudents();
			 m.addAttribute("data", list);
			 return "adminscreen";
		 }else {
			 m.addAttribute("login_fail","Enter valid login details");
			 return "login";
		 }
		
	}
	
	@RequestMapping("/enroll_student")
	public String saveData(@ModelAttribute Student s,Model m) {
		
		ssi.saveData(s);
		
	List<Student> list=ssi.getAllStudents();
		m.addAttribute("data", list);
		return "adminscreen";
	}
	
	
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("id") int studentId,Model m)
	{
	
		ssi.removeStudent(studentId);
		List<Student> list=ssi.getAllStudents();
		m.addAttribute("data", list);
		return "adminscreen";
	}
	
	@RequestMapping("/search")
	public String searchByBatchStudents(@RequestParam("batchNumber") String batchNumber,Model m) {
		
		List<Student> list=ssi.getStudentsByBatch(batchNumber);
		m.addAttribute("data", list);
		return "adminscreen";
	}
	
}
