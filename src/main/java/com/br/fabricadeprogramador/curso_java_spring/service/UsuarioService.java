package com.br.fabricadeprogramador.curso_java_spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.fabricadeprogramador.curso_java_spring.model.Perfil;
import com.br.fabricadeprogramador.curso_java_spring.model.Usuario;
import com.br.fabricadeprogramador.curso_java_spring.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired   //Injeção de dependência
	private UsuarioRepository usuarioRepository;
	
	public Usuario salvar (Usuario usuario) {
		if (usuario.getPerfil() == null) {
			Perfil perfilNovo = new Perfil();
			perfilNovo.setId(2);
			perfilNovo.setDescricao("Convidado");
			usuario.setPerfil(perfilNovo);
		}
		return usuarioRepository.save(usuario);
	}
	public void excluir(Integer id) {
		usuarioRepository.deleteById(id);

	}
	
	public Optional<Usuario> buscarPorId (Integer id) {
		return usuarioRepository.findById(id);
			
	}
	
	public List<Usuario> buscarTodos () {
		return usuarioRepository.findAll();
	
		
	}
	public List<Usuario> buscarPorNome(String nome){
		return usuarioRepository.findByNomeIgnoreCase(nome);
	}
	
	public List<Usuario> buscarPorSenha(String senha) {
		return usuarioRepository.findBySenha(senha);
	}
	
	
	public List<Usuario> buscarPorNomeESenha (String nome, String senha){
		return usuarioRepository.findByNomeAndSenha(nome, senha);
	}
	
	public Boolean autenticar(Usuario usuario) {
		List<Usuario> lista = usuarioRepository.findByNomeAndSenha(usuario.getNome(), usuario.getSenha());
		if (lista==null || lista.size()==0) {
			return false;
		} else {
			return true;
		}
	}
	public List<Usuario> buscarPorPerfil(String descricao){
		// pelo método JPQL
		return usuarioRepository.buscarPorPerfil(descricao);
		// ou pelas palavras chaves
		// return usuarioRepository.findByPerfilDescricao(descricao);
	}
	public List<Usuario> buscarIdNomePorPerfil(String descricao){
		// pelo método JPQL
		return usuarioRepository.buscarIdNomePorPerfil(descricao);
	}

}

