package br.com.truedev.ecommerce.controller;

import br.com.truedev.ecommerce.model.Categoria;
import br.com.truedev.ecommerce.model.Produto;
import br.com.truedev.ecommerce.service.produto.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoServiceImpl produtoService;

    @GetMapping("/produtos")
    public ResponseEntity<Page<Produto>> getAll(@RequestParam(name = "p", defaultValue = "0") int p) {
        return ResponseEntity.ok(produtoService.recuperarTodos(p));
    }

    @GetMapping("/produtos/search")
    public ResponseEntity<List<Produto>> getByPalavraChave(@RequestParam(name = "key") String key) {
        List<Produto> lista = produtoService.recuperarPorPalavraChave(key);
        if (lista.size() > 0) {
            return ResponseEntity.ok(lista);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/produtos/categoria/{id}")
    public ResponseEntity<List<Produto>> getByCategoria(@PathVariable Integer id) {
        Categoria categoria = new Categoria();
        categoria.setId(id);

        return ResponseEntity.ok(produtoService.buscarPorCategoria(categoria));
    }

    @PostMapping("/produtos")
    public ResponseEntity<Produto> post(@RequestBody Produto produto) {
        Produto result = produtoService.cadastrarNovo(produto);
        if (result != null) {
            return ResponseEntity.status(201).body(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<Produto> put(@RequestBody Produto produto, @PathVariable Integer id) {
        produto.setId(id);
        Produto result = produtoService.alterarProdudo(produto);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().build();
    }
}
