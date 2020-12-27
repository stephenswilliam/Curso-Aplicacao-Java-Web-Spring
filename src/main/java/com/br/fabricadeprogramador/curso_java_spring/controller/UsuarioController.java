package com.br.fabricadeprogramador.curso_java_spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.fabricadeprogramador.curso_java_spring.model.Usuario;
import com.br.fabricadeprogramador.curso_java_spring.service.UsuarioService;


/*
 * O comando @RestController equivale ao  @WebServlet urlPatterns, que indica o nome que o client 
 *   poderá usar para invocar essa classe.
*/
@RestController
@RequestMapping("/usucontroller")
@CrossOrigin(origins={"*"}) // * recebe solicitações de qualquer endereço
public class UsuarioController {
	
	
	/*
	 * O comando Autowired solicita ao Spring que, depois de instanciar a classe 
	 * da interface UsuarioResitory, coloque o objeto na variavel usuarioRepository.
	 */
	
	@Autowired   //Injeção de dependência
	private UsuarioService usuarioService;
	
	/*
	 * Criando um método para inserir um Usuário (POST)
	 * o método irá receber um JSON com o usuario a ser salvo, sem o Id 
	 * e retorna um Json com o objeto salvo e com o Id que foi gerado.
	 * 
	 * Os dados do usuario são obtidos do HttpRequest (@RequestBody)
	 *
	 * O método save é o mesmo do put, ele decide se vai incluir ou alterar 
	 * verificando se veio o id ou não.
	*/
	
	@PostMapping
	public Usuario inserir (@RequestBody Usuario usuario) {
		return usuarioService.salvar(usuario);
		
	}
	/*
	 * Criando um método para alterar um Usuário (POST)
	 * o método irá receber um JSON com o usuario a ser alterado, com o Id 
	 * e retorna um Json com o objeto alterado.
	 * 
	 * Os dados do usuario são obtidos do HttpRequest (@RequestBody)
	 * 
	 * O método save é o mesmo do post, ele decide se vai incluir ou alterar 
	 * verificando se veio o id ou não 
	 * 
	 */
	@PutMapping
	public Usuario alterar (@RequestBody Usuario usuario) {
		return usuarioService.salvar(usuario);
		
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable("id") Integer id) {
		usuarioService.excluir(id);

	}
	
	/*
	 * O id será passado na url(no Path) que chamou o get: /id  ou o delete: /id
	 * 
	 * Essa forma pode ser usada também no delete acima
	 */
	

	@GetMapping("/{id}")
	public Optional<Usuario> buscarPorId (@PathVariable("id") Integer id) {
		return usuarioService.buscarPorId(id);
		
	}
	/*
	 * Traz uma lista de usuarios. 
	 */
	
	@GetMapping
	public List<Usuario> buscarTodos () {
		return usuarioService.buscarTodos() ;
	
		
	}
	@GetMapping("/nome/{nome}")
	public List<Usuario> buscarPorNome(@PathVariable("nome") String nome){
		return usuarioService.buscarPorNome(nome);
	}
	@GetMapping("/senha/{senha}")
	public List<Usuario> buscarPorSenha(@PathVariable("senha") String senha) {
		return usuarioService.buscarPorSenha(senha);
	}
	
	/*
	 * Na solicitacão de consulta por Get os dados são passados na URL e se tornam vulneráveis
	 */
	@GetMapping("/nomesenha/{nome},{senha}")
	public List<Usuario> buscarPorNomeESenha (@PathVariable("nome")String nome, @PathVariable("senha") String senha){
		return usuarioService.buscarPorNomeESenha(nome, senha);
	}
	/*
	 * O ideal é fazer a consulta por Post, passando os dados no Gson
	 */
	@GetMapping("/autenticar")
	public Boolean autenticar(@RequestBody Usuario usuario) {
		return usuarioService.autenticar(usuario);
		
	}
	@GetMapping("/perfil")
	public List<Usuario> buscarPorPerfil(@RequestParam("descricao") String descricao){
		return usuarioService.buscarPorPerfil(descricao);
		
	}
	@GetMapping("/idnomeperfil")
	public List<Usuario> buscarIdNomePorPerfil(@RequestParam("descricao") String descricao){
		return usuarioService.buscarIdNomePorPerfil(descricao);
	}
	
}
