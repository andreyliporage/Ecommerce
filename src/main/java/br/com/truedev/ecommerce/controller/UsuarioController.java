package br.com.truedev.ecommerce.controller;

import br.com.truedev.ecommerce.model.Usuario;
import br.com.truedev.ecommerce.security.ECToken;
import br.com.truedev.ecommerce.service.usuario.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> post(@RequestBody Usuario novo) {
        Usuario result = usuarioService.cadastrarNovo(novo);
        if (result != null) {
            return ResponseEntity.status(201).body(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/login")
    public ResponseEntity<ECToken> login(@RequestBody Usuario usuario) {
        ECToken ecToken = usuarioService.fazerLogin(usuario.getLogin(), usuario.getSenha());
        if (ecToken != null) {
            return ResponseEntity.ok(ecToken);
        }
        return ResponseEntity.status(403).build();
    }
}
