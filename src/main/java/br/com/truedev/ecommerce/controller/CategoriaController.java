package br.com.truedev.ecommerce.controller;

import br.com.truedev.ecommerce.model.Categoria;
import br.com.truedev.ecommerce.service.categoria.CategoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaServiceImpl categoriaService;

    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> GetAll() {
        return ResponseEntity.ok(categoriaService.listarTudo());
    }

    @PostMapping("/categorias")
    public ResponseEntity<Categoria> post(@RequestBody Categoria categoria) {
        Categoria result = categoriaService.criarNova(categoria);
        if (result != null) {
            return ResponseEntity.status(201).body(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/categorias/{id}")
    public ResponseEntity<Categoria> put(@RequestBody Categoria categoria, @PathVariable Integer id) {
        categoria.setId(id);
        Categoria result = categoriaService.alterar(categoria);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        categoriaService.apagarCategoria(id);
        return ResponseEntity.ok("Removed");
    }
}
