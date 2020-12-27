package com.br.fabricadeprogramador.curso_java_spring.model;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data //Cria automáticamente os getters e setters e esconde o código gerado
@Entity  //JPA indica que a classe abaixo é uma entidade que será persistida por um framework
@NamedQueries(value = { 
		@NamedQuery(  
				name = "Usuario.buscarPorPerfil", 
				query = "Select u from Usuario u where u.perfil.descricao= :desc")
			// u é o apelido da classe Usuario
			// Será instanciado um usuario com nome u para cada registro da tabela que atender a condicao where
			//:desc é um parametro que será substituido pelo @Param informado na chama do método buscarPorPerfil na classe UsuarioRepository
,		
		@NamedQuery(
				name = "Usuario.buscarIdNomePorPerfil", 
				query = "Select new Usuario (u.id, u.nome) from Usuario u where u.perfil.descricao= :desc")
			//Para esta query foi necessário criar um construtor com id e nome
})
public class Usuario {
	@Id  										//JPA indica que o campo abaixo é um campo chave
	@GeneratedValue(generator = "seq_usuario") 	//indica que os valores serão gerados automaticamente sobre controle do framwork
	@SequenceGenerator(name = "seq_usuario", sequenceName = "seq_usuario")
	private Integer id;
	private String nome;
	private String senha;
	@JoinColumn
	@ManyToOne
	private Perfil perfil;
	
	public Usuario() {}
	
	public Usuario(Integer id, String nome) {
		this.id=id;
		this.nome=nome;
	}

}
