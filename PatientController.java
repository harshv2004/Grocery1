package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Patient;
import com.example.demo.repositories.PatientRepository;

@RestController
public class PatientController {
	@Autowired
	PatientRepository prepo;
	
	@GetMapping("/")
	public String addData()
	{		
		return "index";
	}	
	@PostMapping("/patient/add")
	public String addData(Patient p)
	{
		prepo.save(p);
		return "Record Added";
	}
	
	
	@GetMapping("/patient/display")
	public String displayCar(Model model)
	{	
		List<Patient> p_list=(List<Patient>)prepo.findAll();
		model.addAttribute("p",p_list);
		return "display";
	}
	
	
	
	@GetMapping("/patient/delete/{id}")
	public String deleteCar(@PathVariable("id")Integer id)
	{	
		prepo.deleteById(id);
		return "redirect:/patient/display";
		
	}
	
	@GetMapping("/patient/edit/{id}")
	public String editCar(@PathVariable("id")Integer id, Model model)
	{	
		Patient p =	prepo.findById(id).get();
		
		model.addAttribute("p",p);
		return "edit";
	}
	@PostMapping("/patient/edit")
	public String editCar(Patient p)
	{	
		Integer id=p.getId();
		String Name=p.getName();
		String Disease=p.getDisease();
		String admissionDate=p.getAdmissionDate();
		
		Patient pDB =	prepo.findById(id).get();
		
		pDB.setName(Name);
		pDB.setDisease(Disease);
		pDB.setAdmissionDate(admissionDate);
		
		prepo.save(pDB);
		
//		model.addAttribute("p",p);
		
		return "redirect:/patient/display";
	}
}

