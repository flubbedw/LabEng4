package com.crud.ListaStudents.controller;

import com.crud.ListaStudents.model.Student;
import com.crud.ListaStudents.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("students.html");
		List<Student> students = studentRepository.findAll();
		modelAndView.addObject("students", students);
		modelAndView.addObject(new Student());

		return modelAndView;
	}
	
	@PostMapping("/students")
	//o spring recebe o object do form e passa para o parâmetro do método
	public RedirectView salvar(Student student) {
		studentRepository.save(student);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("/students");
		return redirectView;
		
	}

}