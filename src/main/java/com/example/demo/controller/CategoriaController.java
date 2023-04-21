package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Categoria;
import com.example.demo.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@GetMapping("/status")
	public String status() {
		return "pong";
	}
	
	@GetMapping
	public String allCategorias() {
		return "listar categorias";
	}
	
	@GetMapping("/{id}")
	public String categoriaById(@PathVariable Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		
		if (categoria.isPresent()) {
			return categoria.get().getDescripcion();
		}
		
		return null;
	}
	
	@PostMapping
	public String addCategorias(@RequestBody Categoria categoria) {
		return "Post categorias";
	}
	
	@PutMapping("/{id}")
	public String updateCategorias(@PathVariable String id, @RequestBody Categoria categoria) {
		return "Put categorias " + id;
	}
	
	@DeleteMapping("/{id}")
	public String deleteCategorias(@PathVariable String id) {
		return "Delete categorias " + id;
	}
	
}
