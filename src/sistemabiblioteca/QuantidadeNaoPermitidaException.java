package sistemabiblioteca;

/**
 * Exceção a ser lançada quando a quantidade de
 * livros de um usuário não for aceita.
 */
public class QuantidadeNaoPermitidaException extends Exception {

	private static final long serialVersionUID = 1L;
	public static String MSG_QUANTIDADE_INVALIDA = "A quantidade de livros que o usuário tem excede as regras da biblioteca.";
	
	public QuantidadeNaoPermitidaException(String msg) {
		super(msg);
	}
}
