package com.fatec.festa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.festa.model.Convidado;
import com.fatec.festa.repository.ConvidadoRepository;

@RestController
public class ConvidadoController {
	
	@Autowired
	ConvidadoRepository convidadoRepository;
	
	@GetMapping("/convidados")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("listar_convidados.html");
		List<Convidado> convidados = convidadoRepository.findAll();
		modelAndView.addObject("convidados", convidados);

		return modelAndView;
	}

}
