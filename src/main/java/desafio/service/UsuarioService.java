package desafio.service;

import desafio.model.Usuario;
import desafio.repository.UsuarioRepository;
import desafio.utils.TextoUtils;

public class UsuarioService {
	private final UsuarioRepository rep = new UsuarioRepository();

	public void incluir(Usuario usuario) {
		if (TextoUtils.validaComprimento(usuario.getLogin(), 20)) {
			throw new IllegalArgumentException("Login excede o máximo de caracteres (20)");
		}

		if (TextoUtils.validaComprimento(usuario.getSenha(), 100)) {
			throw new IllegalArgumentException("Senha excede o máximo de caracteres (100)");
		}

		if (rep.exists(usuario.getLogin())) {
			throw new IllegalStateException("Já existe um usuario com o login " + usuario.getLogin());
		}

		rep.incluir(usuario);
		System.out.println("UsuarioRepository::incluir() -> FIM");
	}
}
