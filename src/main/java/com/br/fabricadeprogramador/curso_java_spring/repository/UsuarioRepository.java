package com.br.fabricadeprogramador.curso_java_spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.br.fabricadeprogramador.curso_java_spring.model.Usuario;

/* a interface abaixo extende a interface JpaRepository do Spring Framework
 * que tem todos os métodos padrões de persistencia (CRUD)
 * indicamos o nome da classe model e o tipo da chave primaria como parametros
 * podemos, também, incluir métodos personalizados
 */
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
	/*
	 * Consulta utilizando palavras pré definidas...
	 */
	public List<Usuario> findByNomeIgnoreCase(String nome);
	
	public List<Usuario> findBySenha(String senha);
	
	public List<Usuario> findByNomeAndSenha(String nome, String senha );
	
	public List<Usuario> findByPerfilDescricao(String descricao);	
	/* o método criado baixo, usando consultas customizadas tem o mesmo efeito que este acima.
	
	/*
	 * Para criar consultas customizadas...
	 * Consulta JPQL (Jakarta Persistence Query Language), linguagem implementada pelo framework, 
	 * 		muito parecida com o SQL, consultando por classes(objetos).
	 * A Query é definida na classe Usuario, usando a notação @NamedQuery da JPQL,
	 *		no caso com o nome buscarPorPerfil e ira receber o parametro desc com o
	 *		conteúdo da descrição recebida por que chamou esse método (veja UsuarioContrller)
	 */
	
	public List<Usuario> buscarPorPerfil(String descricao);
	
	public List<Usuario> buscarIdNomePorPerfil(String descricao);
	
	
}


