package com.br.fabricadeprogramador.curso_java_spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import org.springframework.data.querydsl.binding.QuerydslPredicate;

import lombok.Data;

@Data
@Entity
@NamedQuery(
		name = "Produto.obtemMaior", 
		query = "Select p from Produto p where p.valor = (Select MAX(r.valor) from Produto r)")
@NamedQuery(
		name = "Produto.obtemMenor", 
		query = "Select p from Produto p where p.valor = (Select MIN(r.valor) from Produto r)")
@NamedQuery(
		name = "Produto.obtemMedia", 
		query = "Select AVG(p.valor) from Produto p")
@NamedQuery(
		name = "Produto.obtemOrdem", 
		query = "Select p from Produto p order by p.valor desc")
public class Produto {
	@Id
	@GeneratedValue(generator = "seq_produto")
	@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto")
	Integer id;
	String descricao;
	Integer valor;

}
