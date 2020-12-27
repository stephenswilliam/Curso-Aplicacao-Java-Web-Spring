package com.br.fabricadeprogramador.curso_java_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.fabricadeprogramador.curso_java_spring.model.Produto;
import com.br.fabricadeprogramador.curso_java_spring.repository.ProdutoRepository;

@RestController
@RequestMapping("/prodcontroller")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@PostMapping
	private Produto inserir(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	@GetMapping
	private List<Produto> obterTodos(){
		return produtoRepository.findAll();
	}
	@GetMapping("/maior")
	private Produto obterMaior() {
		return produtoRepository.obtemMaior();
	}
	@GetMapping("/menor")
	private Produto obterMenor() {
		return produtoRepository.obtemMenor();
	}
	@GetMapping("/media")
	private String obterMedia() {
		return produtoRepository.obtemMedia();
	}
	@GetMapping("/ordem")
	private List<Produto> obterOrdem() {
		return produtoRepository.obtemOrdem();
	}
}
