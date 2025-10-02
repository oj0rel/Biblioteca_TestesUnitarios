package sistemabiblioteca;

import java.util.List;

/**
 * Classe {@link GerenciadoraUsuarios} para gerenciar as funcionalidades da classe {@link Usuario}.
 * @author gabriel.silva
 * @date 02/10/2025
 */
public class GerenciadoraUsuarios {

	private List<Usuario> usuariosDaBiblioteca;

	
	public GerenciadoraUsuarios(List<Usuario> usuariosDaBiblioteca) {
		this.usuariosDaBiblioteca = usuariosDaBiblioteca;
	}
	
	/**
	 * Método que retorna uma lista de usuários da biblioteca.
	 * @return usuariosDaBlibioteca -> lista com todos os usuários da biblioteca.
	 */
	public List<Usuario> getUsuariosDaBiblioteca() {
		return usuariosDaBiblioteca;
	}
	
	/**
	 * Método que faz uma pesquisa através dos usuários da biblioteca
	 * pelo ID do usuário desejado.
	 * @param idUsuario -> ID do usuário a ser buscado.
	 * @return o usuario buscado ou null, caso não seja encontrado
	 */
	public Usuario pesquisarUsuario(Integer usuarioId) {
		for (Usuario usuario : usuariosDaBiblioteca) {
			if(usuario.getId() == usuarioId) {
				return usuario;
			}
		}
		return null;
	}
	
	/**
	 * Método que adiciona um usuário à lista de usuários da biblioteca.
	 * @param usuario -> usuário a ser adicionado.
	 */
	public void adicionarUsuario(Usuario usuario) {
		usuariosDaBiblioteca.add(usuario);
	}
	
	/**
	 * Método que remove um usuário da lista de usuários da biblioteca.
	 * @param idUsuario -> id do usuário a ser removido.
	 * @return usuarioRemovido -> variável boolean que diz se o usuário foi
	 * removido(true) ou não(false).
	 */
	public boolean removerUsuario(Integer usuarioId) {
		boolean usuarioRemovido = false;
		
		for (int i = 0; i < usuariosDaBiblioteca.size(); i++) {
			Usuario usuario = usuariosDaBiblioteca.get(i);
			if (usuario.getId() == usuarioId) {
				usuariosDaBiblioteca.remove(i);
				usuarioRemovido = true;
				break;
			}
		}
		
		return usuarioRemovido;
	}
	
	/**
	 * Método para verificar se o status do usuário está ativo.
	 * @param idUsuario -> ID do usuário a ser buscado.
	 * @return usuarioAtivo -> variável boolean indicando se o usuário está ativo(true)
	 * ou não(false).
	 */
	public boolean usuarioAtivo(Integer usuarioId) {
		boolean usuarioAtivo = false;
		
		for (int i = 0; i < usuariosDaBiblioteca.size(); i++) {
			Usuario usuario = usuariosDaBiblioteca.get(i);
			if (usuario.getId() == usuarioId) {
				usuarioAtivo = true;
				break;
			}
		}
		
		return usuarioAtivo;
	}
	
	/**
	 * Método que adiciona livros para um usuário da biblioteca.
	 * @param quantidadeParaEmprestar -> quantidade de livros a serem adicionados em um usuário.
	 * @param idUsuario -> ID do usuário que deve ser usado no método.
	 * @return mensagem indicando se os livros foram emprestados ou não.
	 */
	public void adicionarLivro(Integer quantidadeParaEmprestar, Integer usuarioId) {
		for (int i = 0; i < usuariosDaBiblioteca.size(); i++) {
			Usuario usuario = usuariosDaBiblioteca.get(i);
			
			if (usuario.getId() == usuarioId) {
				Integer livrosDoUsuario = usuario.getQuantidadeDeLivros();
				usuario.setQuantidadeDeLivros(livrosDoUsuario + quantidadeParaEmprestar);
				System.out.println("Livros emprestados!");
				break;
			}
		}
		
		System.out.println("Os livros não foram emprestados!");
	}
	
	/**
	 * Limpa a lista de usuários da biblioteca, removendo todos eles.
	 */
	public void limpar() {
		usuariosDaBiblioteca.clear();
	}
	
	/**
	 * Valida se um usuário está com uma quantidade de livros permitida pela biblioteca (0 - 3).
	 * @param quantidadeDeLivros -> quantidade que será adicionada ao usuário.
	 */
	public boolean validarLimiteDeLivros(Integer quantidadeDeLivros) throws QuantidadeNaoPermitidaException {
		if (quantidadeDeLivros < 0 || quantidadeDeLivros > 3) {
			throw new QuantidadeNaoPermitidaException(QuantidadeNaoPermitidaException.MSG_QUANTIDADE_INVALIDA);
		}
		
		return true;
	}
}
