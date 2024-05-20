package br.com.truedev.ecommerce.controller;

import br.com.truedev.ecommerce.model.Cliente;
import br.com.truedev.ecommerce.service.cliente.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService iClienteService;

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(iClienteService.recuperaTodos());
    }

    @GetMapping("/clientes/busca")
    public ResponseEntity<Cliente> getByPhone(@RequestParam(name = "telefone") String telefone) {
        Cliente result = iClienteService.recuperaClientePeloTelefone(telefone);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/clientes/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Integer id) {
        Cliente result = iClienteService.recuperaClientePeloId(id);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> insertNew(@RequestBody Cliente novo) {
        try {
            Cliente result = iClienteService.cadastraNovoCliente(novo);
            if (result!= null) {
                return ResponseEntity.status(201).body(result);
            }
        } catch (Exception ex) {
            System.out.println("LOG - Erro ao cadastrar - "+ex.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente, @PathVariable Integer id) {
        cliente.setId(id);

        try {
            Cliente result = iClienteService.alteraCliente(cliente);
            if (result != null) {
                return ResponseEntity.ok(cliente);
            }
        } catch (Exception ex) {
            System.out.println("LOG - Erro ao atualizar - "+ex.getMessage());
        }

        return ResponseEntity.badRequest().build();
    }
}
