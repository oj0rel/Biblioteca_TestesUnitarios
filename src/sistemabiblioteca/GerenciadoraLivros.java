package sistemabiblioteca;

import java.util.List;

/**
 * Classe {@link GerenciadoraLivros} para gerenciar as funcionalidades da classe {@link Livro}.
 * @author gabriel.silva
 * @date 02/10/2025
 */
public class GerenciadoraLivros {

	public List<Livro> livrosDaBiblioteca;
	
	public GerenciadoraLivros(List<Livro> livrosDaBiblioteca) {
		this.livrosDaBiblioteca = livrosDaBiblioteca;
	}
	
	/**
	 * Método que retorna uma lista de todos os livros registrados na biblioteca.
	 * @return livrosDaBiblioteca -> lista de todos os livros da biblioteca.
	 */
	public List<Livro> getLivrosDaBiblioteca() {
		return livrosDaBiblioteca;
	}
	
	/**
	 * Método que faz uma pesquisa através dos livros da biblitoeca
	 * pelo ID do livro desejado.
	 * @param livroId -> ID do livro buscado.
	 * @return o livro buscado ou null, caso não esteja registrado na bibliotca.
	 */
	public Livro pesquisarLivro(Integer livroId) {
		for (Livro livro : livrosDaBiblioteca) {
			if (livro.getId() == livroId) {
				return livro;
			}
		}
		
		return null;
	}
	
	/**
	 * Método que adiciona um livro à lista de livros da biblioteca.
	 * @param livro -> livro que deseja adicionar.
	 */
	public void adicionarLivro(Livro livro) {
		livrosDaBiblioteca.add(livro);
	}
	
	/**
	 * Método que remove um livro da lista de livros da biblioteca.
	 * @param livroId -> ID do livro a ser removido.
	 * @return livroRemovido -> variável boolean indicando se foi removido(true) ou não(false).
	 */
	public boolean removerLivro(Integer livroId) {
		boolean livroRemovido = false;
		
		for (Livro livro : livrosDaBiblioteca) {
			if (livro.getId() == livroId) {
				livrosDaBiblioteca.remove(livro);
				livroRemovido = true;
				break;
			}
		}
		
		return livroRemovido;
	}
	
	/**
	 * Método para verificar se um livro da biblioteca está com status ativo.
	 * @param livroId -> ID do livro a ser buscado.
	 * @return livroAtivo -> variável boolean indicando se o livro está ativo(true) ou não(false).
	 */
	public boolean livroAtivo(Integer livroId) {
		boolean livroAtivo = false;
		
		for (Livro livro : livrosDaBiblioteca) {
			if (livro.getId() == livroId) {
				livroAtivo = true;
				break;
			}
		}
		
		return livroAtivo;
	}
	
	/**
	 * Método para emprestar um livro da biblioteca, alterando seu estado de emprestado.
	 * @param livroId -> ID do livro a ser emprestado.
	 * @return livroEmprestado -> variável boolean que indica se o livro
	 * foi emprestado(true) ou não(false).
	 */
	public boolean emprestarLivro(Integer livroId) {
		boolean livroEmprestado = false;
		
		for (Livro livro : livrosDaBiblioteca) {
			if (livro.getId() == livroId) {
				livro.emprestar();
				livroEmprestado = true;
				break;
			}
		}
		
		return livroEmprestado;
	}
	
	/**
	 * Método para devolver um livro da biblioteca, alterando seu estado de emprestado.
	 * @param livroId -> ID do livro a ser devolvido.
	 * @return livroDevolvido -> variável boolean que indica se o livro
	 * foi devolvido(true) ou não(false).
	 */
	public boolean devolverLivro(Integer livroId) {
		boolean livroDevolvido = false;
		
		for (Livro livro : livrosDaBiblioteca) {
			if (livro.getId() == livroId) {
				livro.devolver();
				livroDevolvido = true;
				break;
			}
		}
		
		return livroDevolvido;
	}
	
	
}
