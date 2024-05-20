package br.com.truedev.ecommerce.service.usuario;

import br.com.truedev.ecommerce.model.Usuario;
import br.com.truedev.ecommerce.security.ECToken;

public interface IUsuarioService {
    Usuario cadastrarNovo(Usuario novo);
    Usuario alterarDados(Usuario usuario);
    ECToken fazerLogin(String login, String senha);
}
