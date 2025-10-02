package sistemabiblioteca;

import java.util.List;

public class GerenciadoraUsuarios {

	private List<Usuario> usuariosDaBiblioteca;

	
	public GerenciadoraUsuarios(List<Usuario> usuariosDaBiblioteca) {
		this.usuariosDaBiblioteca = usuariosDaBiblioteca;
	}
	
	public List<Usuario> getUsuariosDaBiblioteca() {
		return usuariosDaBiblioteca;
	}
	
	public Usuario pesquisaUsuario(Integer idUsuario) {
		
		for (Usuario usuario : usuariosDaBiblioteca) {
			if(usuario.getId() == idUsuario) {
				return usuario;
			}
		}
		return null;
	}
	
	public void adicionaUsuario(Usuario usuario) {
		usuariosDaBiblioteca.add(usuario);
	}
	
	public boolean removeUsuario(Integer idUsuario) {
		
		boolean usuarioRemovido = false;
		
		for (int i = 0; i < usuariosDaBiblioteca.size(); i++) {
			Usuario usuario = usuariosDaBiblioteca.get(i);
			if (usuario.getId() == idUsuario) {
				usuariosDaBiblioteca.remove(i);
				usuarioRemovido = true;
				break;
			}
		}
		
		return usuarioRemovido;
	}
	
	public boolean usuarioAtivo(Integer idUsuario) {
		
		boolean usuarioAtivo = false;
		
		for (int i = 0; i < usuariosDaBiblioteca.size(); i++) {
			Usuario usuario = usuariosDaBiblioteca.get(i);
			if (usuario.getId() == idUsuario) {
				usuarioAtivo = true;
				break;
			}
		}
		
		return usuarioAtivo;
	}
	
	public void limpa() {
		usuariosDaBiblioteca.clear();
	}
	
	public boolean validaLimiteDeLivros(Integer quantidadeDeLivros) throws QuantidadeNaoPermitidaException {
		
		if (quantidadeDeLivros > 3) {
			throw new QuantidadeNaoPermitidaException(QuantidadeNaoPermitidaException.MSG_QUANTIDADE_INVALIDA);
		}
		
		return true;
	}
}
