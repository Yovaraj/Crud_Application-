package com.example.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.entity.Employee;
import com.example.service.EmpService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	@GetMapping("/index")
	public String home(Model m)
	{
		List <Employee>emp = service.getAllEmp();
		m.addAttribute("emp",emp);
		return "index";
	}
	@GetMapping("/addemp")
	public String addEmpForm()
	{
		return "add_emp";
	}
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,HttpSession session)
	{
		System.out.println(e);
		
		service.addEmp(e);	
		session.setAttribute("msg", "Employee Added Successfully.."+e);
	return "redirect:/index";	
	}
	@GetMapping("/edit/{id")
	public String edit(@PathVariable int id, Model m) {
		Employee e = service.getEMpById(id);
		m.addAttribute("emp",e);
		return "edit";
	}
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e,HttpSession session)
	{
		service.addEmp(e);
		session.setAttribute("msg","Emp Data Update Successfully..");
		return "rediect:/";
	}
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id, Model m,HttpSession session)
	{
		service.deletEmp(id);
		session.setAttribute("msg","Emp Data Deleted Successfully..");
		return "rediect:/";
	}

}
