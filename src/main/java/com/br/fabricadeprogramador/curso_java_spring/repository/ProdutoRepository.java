package com.br.fabricadeprogramador.curso_java_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.br.fabricadeprogramador.curso_java_spring.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

	public Produto obtemMaior();
	
	public Produto obtemMenor();

	public String obtemMedia();

	public List<Produto> obtemOrdem();
	
	
	

}
