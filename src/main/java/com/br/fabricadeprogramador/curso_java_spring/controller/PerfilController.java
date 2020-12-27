package com.br.fabricadeprogramador.curso_java_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fabricadeprogramador.curso_java_spring.model.Perfil;
import com.br.fabricadeprogramador.curso_java_spring.model.Usuario;
import com.br.fabricadeprogramador.curso_java_spring.repository.PerfilRepository;

@RestController
@RequestMapping("/perfilcontroller")
@CrossOrigin(origins= {"*"})
public class PerfilController {

	@Autowired
	private PerfilRepository perfilRepository;
	
	@PostMapping
	public Perfil inserir (@RequestBody Perfil perfil) {
		return perfilRepository.save(perfil);
	}
	@PutMapping
	public Perfil alterar (@RequestBody Perfil perfil) {
		return perfilRepository.save(perfil);
	}
	@DeleteMapping("/{id}")
	public void excluir (@PathVariable("id") Integer id) {
		perfilRepository.deleteById(id);
	}
	@GetMapping
	public List<Perfil> obterTodos (){
		return perfilRepository.findAll();
	}
}
