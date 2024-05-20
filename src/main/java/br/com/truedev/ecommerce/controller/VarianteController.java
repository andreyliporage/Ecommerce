package br.com.truedev.ecommerce.controller;

import br.com.truedev.ecommerce.model.Produto;
import br.com.truedev.ecommerce.model.Variante;
import br.com.truedev.ecommerce.service.variante.IVarianteService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VarianteController {

    @Autowired
    private IVarianteService varianteService;

    @PostMapping("/variantes")
    public ResponseEntity<Variante> post(@RequestBody Variante variante) {
        Variante var = varianteService.adicionarNova(variante);
        if (var != null) {
            return ResponseEntity.ok(var);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/variantes/{id}")
    public ResponseEntity<Variante> put(@RequestBody Variante variante, @PathVariable Integer id) {
        variante.setId(id);
        Variante var = varianteService.alterarDados(variante);
        if (var != null) {
            return ResponseEntity.ok(var);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/variantes/{id}")
    public ResponseEntity<Variante> getById(@PathVariable Integer id) {
        Variante var = varianteService.recuperarPeloId(id);
        if (var != null) {
            return ResponseEntity.ok(var);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/variantes")
    public ResponseEntity<List<Variante>> getByProduto(@RequestParam(name = "idproduto") Integer idproduto) {
        Produto produto = new Produto();
        produto.setId(idproduto);
        return ResponseEntity.ok(varianteService.recuperarPorProduto(produto));
    }
}
