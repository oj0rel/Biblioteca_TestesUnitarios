package sistemabiblioteca;

/**
 * Classe {@link Usuario} que representa um usuário real de uma biblioteca.
 * @author gabriel.silva
 * @date 01/10/2025
 */
public class Usuario {

	private Integer id;
	private String nome;
	private Integer limiteDeLivros;
	private boolean ativo;
	
	private Integer idLivro;
	
	public Usuario(Integer id, String nome, Integer limiteDeLivros, Integer idLivro) {
		this.id = id;
		this.nome = nome;
		this.limiteDeLivros = limiteDeLivros;
		this.ativo = true;
		this.idLivro = idLivro;
	}
	
	/**
	 * Método que retorna o ID do usuário.
	 * @return ID do Usuario.
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Método que atualiza o ID do usuário.
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Método que retorna o nome do usuário.
	 * @return Nome do Usuario.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Método que atualiza o nome do usuário.
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Método que retorna o limite de livros do usuário.
	 * @return Limite de livros do Usuario.
	 */
	public Integer getLimiteDeLivros() {
		return limiteDeLivros;
	}
	
	/**
	 * Método para atualizar o limite de livros do usuário.
	 * @param limiteDeLivros
	 */
	public void setLimiteDeLivros(Integer limiteDeLivros) {
		this.limiteDeLivros = limiteDeLivros;
	}
	
	/**
	 * Método para retornar status do usuário.
	 * @return status do Usuario.
	 */
	public boolean isAtivo() {
		return ativo;
	}

	/**
	 * Método para atualizar status do usuário.
	 * @param ativo
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	/**
	 * Método para retornar o ID do Livro associado a este usuário.
	 * @return ID do Livro.
	 */
	public Integer getIdLivro() {
		return idLivro;
	}

	/**
	 * Método para atualizar o ID do Livro associado a este usuário.
	 * @param idLivro
	 */
	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}
	
	/**
	 * Método que retorna a representação textual de um usuário.
	 * @return representação textual de um usuário.
	 */
	@Override
	public String toString() {
		
		String representacao = "========================="
								+"ID: " + this.id + "\n"
								+"Nome: " + this.nome + "\n"
								+"Limite de livros: " + this.limiteDeLivros + "\n"
								+ "Status: " + (ativo?"Ativo":"Inativo") + "\n"
								+ "=========================";
		
		return representacao;
	}
	
}
