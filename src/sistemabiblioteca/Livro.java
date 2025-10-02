package sistemabiblioteca;

/**
 * Classe {@link Livro} que representa um livro real da biblioteca.
 * @author gabriel.silva
 * @date 01/10/2025
 */
public class Livro {
	
	private Integer id;
	private String titulo;
	private String autor;
	private boolean emprestado;
	private boolean ativo;
	
	public Livro(Integer id, String titulo, String autor, boolean ativo) {
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.emprestado = false;
		this.ativo = ativo;
	}
	
	/**
	 * Método para retornar o ID do livro.
	 * @return ID do Livro.
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Método para atualizar o ID do livro.
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Método para retornar o Título do livro.
	 * @return Título do Livro.
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * Método para atualizar o Título do livro.
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * Método para retornar o Autor do livro.
	 * @return Autor do Livro.
	 */
	public String getAutor() {
		return autor;
	}
	
	/**
	 * Método para atualizar o Autor do livro.
	 * @param autor
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	/**
	 * Método para retornar o estado do Livro.
	 * @return Estado do Livro.
	 */
	public boolean isEmprestado() {
		return emprestado;
	}
	
	/**
	 * Método para atualizar o estado do Livro.
	 * @param emprestado
	 */
	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}

	/**
	 * Método que retorna status do Livro.
	 * @return status do Livro.
	 */
	public boolean isAtivo() {
		return ativo;
	}

	/**
	 * Método para atualizar status do Livro.
	 * @param ativo
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	/**
	 * Método para emprestar um livro, mudando seu estado.
	 * Faz também a verificação para ter certeza que este livro está disponível.
	 */
	public void emprestar() {
		if (emprestado) {
			throw new IllegalStateException("O livro já está emprestado!");
		}
		
		emprestado = true;
	}
	
	/**
	 * Método para devolver um livro, mudando seu estado.
	 * Faz também a verificação para ter certeza de que este livro foi realmente emprestado.
	 */
	public void devolver() {
		if (!emprestado) {
			throw new IllegalStateException("O livro não está emprestado!");
		}
		
		emprestado = false;
	}
	
	/**
	 * Método que retorna a representação textual de um livro.
	 * @return representação textual do livro.
	 */
	@Override
	public String toString() {
		
		String representacao = "========================="
								+ "ID: " + this.id + "\n"
								+ "Título: " + this.titulo + "\n"
								+ "Autor: " + this.autor + "\n"
								+ "Emprestado: " + (emprestado?"SIM":"NÃO") + "\n"
								+ "Status: " + (ativo?"ATIVO":"INATIVO") + "\n"
								+ "=========================";
		
		return representacao;
	}
	
}
