package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Categoria;
import com.example.demo.repository.CategoriaRepository;

@Controller
@RequestMapping("/categorias_view")
public class CategoriaViewController {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Categoria> categorias = categoriaRepository.findAll();
		model.addAttribute("categorias", categorias);
		return "index";
	}
	
}
