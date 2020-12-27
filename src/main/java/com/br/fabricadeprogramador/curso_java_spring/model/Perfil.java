package com.br.fabricadeprogramador.curso_java_spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Perfil {
	@Id
	@GeneratedValue(generator = "seq_perfil")
	@SequenceGenerator(name = "seq_perfil", sequenceName = "seq_perfil")
	private Integer id;
	private String descricao;
	

}
