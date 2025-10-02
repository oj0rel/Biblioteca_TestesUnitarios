package sistemabiblioteca;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

/**
 * Classe de teste criada para garantir o funcionamento das principais
 * operações sobre usuários, realizados pela classe {@link GerenciadoraUsuarios}
 * @author gabriel.silva
 * @date 02/10/2025
 */
public class GerenciadoraUsuariosTeste {

	private GerenciadoraUsuarios gerUsuarios;
	
	/**
	 * Método responsável pela montagem do cenário de testes.
	 * @author gabriel.silva
	 * @date 02/10/2025
	 */
	@Before
	public void setUp() {
		
		Usuario usuario01 = new Usuario(1, "Gabriel", 0, true, 1);
		Usuario usuario02 = new Usuario(2, "Silva", 2, true, 2);
		
		List<Usuario> usuariosDaBiblioteca = new ArrayList<Usuario>();
		usuariosDaBiblioteca.add(usuario01);
		usuariosDaBiblioteca.add(usuario02);
		
		gerUsuarios = new GerenciadoraUsuarios(usuariosDaBiblioteca);
	}
	
	/**
	 * Método responsável por fazer a desmontagem do cenário de testes.
	 * @author gabriel.silva
	 * @date 02/10/2025
	 */
	@After
	public void tearDown() {
		gerUsuarios.limpar();
	}
	
	
	private Integer idUsuario01 = 1;
	private Integer idUsuario02 = 2;
	
	/**
	 * Teste de pesquisa de um usuário na biblioteca, a partir do seu ID.
	 * @author gabriel.silva
	 * @date 02/10/2025
	 */
	@Test
	public void testePesquisaUsuario() {
		Usuario usuario = gerUsuarios.pesquisarUsuario(idUsuario01);
		
		assertThat(usuario.getId(), is(1));
		assertThat(usuario.getNome(), is("Gabriel"));
	}
	
	/**
	 * Teste de remoção de um usuário do registro da biblioteca, a partir do seu ID.
	 * @author gabriel.silva
	 * @date 02/10/2025
	 */
	@Test
	public void testeRemoveUsuario() {
		boolean usuarioRemovido = gerUsuarios.removerUsuario(idUsuario01);
		
		assertThat(usuarioRemovido, is(true));
		assertTrue(usuarioRemovido);
		assertThat(gerUsuarios.getUsuariosDaBiblioteca().size(), is(1));
		assertNull(gerUsuarios.pesquisarUsuario(idUsuario01));
	}
	
	/**
	 * Teste de remoção de um usuário inexistente do registro da biblioteca, a partir do ID.
	 * @author gabriel.silva
	 * @date 02/10/2025
	 */
	@Test
	public void testeRemoveUsuarioInexistente() {
		boolean usuarioRemovido = gerUsuarios.removerUsuario(10);
		
		assertFalse(usuarioRemovido);
		assertThat(usuarioRemovido, is(false));
		assertThat(gerUsuarios.getUsuariosDaBiblioteca().size(), is(2));
		assertNull(gerUsuarios.pesquisarUsuario(10));
	}
	
	/**
	 * Teste para verificar a quantidade de livros de um usuário, com quantidade dentro do limite.
	 * @throws QuantidadeNaoPermitidaException
	 * @author gabriel.silva
	 * @date 02/10/2025
	 */
	@Test
	public void testeQuantidadeLivroValidaUsuario() throws QuantidadeNaoPermitidaException {
		Usuario usuario = new Usuario(3, "Santos", 2, true, 2);
		
		boolean quantidadeValida = gerUsuarios.validarLimiteDeLivros(usuario.getQuantidadeDeLivros());
		
		assertTrue(quantidadeValida);
	}
	
	/**
	 * Teste para verificar a quantidade de livros de um usuário, com quantidade no limite superior.
	 * @throws QuantidadeNaoPermitidaException
	 * @author gabriel.silva
	 * @date 02/10/2025
	 */
	@Test
	public void testeQuantidadeLivroValidaLimiteSuperiorUsuario() throws QuantidadeNaoPermitidaException {
		Usuario usuario = new Usuario(3, "Santos", 3, true, 2);
		
		boolean quantidadeValida = gerUsuarios.validarLimiteDeLivros(usuario.getQuantidadeDeLivros());
		
		assertTrue(quantidadeValida);
	}
	
	/**
	 * Teste para verificar a quantidade de livros de um usuário, com quantidade no limite inferior.
	 * @throws QuantidadeNaoPermitidaException
	 * @author gabriel.silva
	 * @date 02/10/2025
	 */
	@Test
	public void testeQuantidadeLivroValidaLimiteInferiorUsuario() throws QuantidadeNaoPermitidaException {
		Usuario usuario = new Usuario(3, "Santos", 0, true, 2);
		
		boolean quantidadeValida = gerUsuarios.validarLimiteDeLivros(usuario.getQuantidadeDeLivros());
		
		assertTrue(quantidadeValida);
	}
	
	/**
	 * Teste para verificar a quantidade de livros de um usuário, com quantidade na borda inferior.
	 * @throws QuantidadeNaoPermitidaException
	 * @author gabriel.silva
	 * @date 02/10/2025
	 */
	@Test
	public void testeQuantidadeLivroValidaBordaInferiorUsuario() throws QuantidadeNaoPermitidaException {
		Usuario usuario = new Usuario(3, "Santos", -1, true, 2);
		
		try {
			gerUsuarios.validarLimiteDeLivros(usuario.getQuantidadeDeLivros());
			fail();
		} catch (Exception e) {
			assertThat(e.getMessage(), is(QuantidadeNaoPermitidaException.MSG_QUANTIDADE_INVALIDA));
		}
	}
	
	/**
	 * Teste para verificar a quantidade de livros de um usuário, com quantidade na borda superior.
	 * @throws QuantidadeNaoPermitidaException
	 * @author gabriel.silva
	 * @date 02/10/2025
	 */
	@Test
	public void testeQuantidadeLivroValidaBordaSuperiorUsuario() throws QuantidadeNaoPermitidaException {
		Usuario usuario = new Usuario(3, "Santos", 4, true, 2);
		
		try {
			gerUsuarios.validarLimiteDeLivros(usuario.getQuantidadeDeLivros());
			fail();
		} catch (Exception e) {
			assertThat(e.getMessage(), is(QuantidadeNaoPermitidaException.MSG_QUANTIDADE_INVALIDA));
		}
	}
}
