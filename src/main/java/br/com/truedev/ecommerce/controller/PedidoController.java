package br.com.truedev.ecommerce.controller;

import br.com.truedev.ecommerce.dto.FaturamentoMensal;
import br.com.truedev.ecommerce.model.Pedido;
import br.com.truedev.ecommerce.model.Produto;
import br.com.truedev.ecommerce.service.pedido.IPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PedidoController {

    @Autowired
    private IPedidoService pedidoService;

    @PostMapping("/pedidos")
    public ResponseEntity<Pedido> post(@RequestBody Pedido pedido) {
        Pedido result = pedidoService.criarNovoPedido(pedido);
        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/pedidos")
    public ResponseEntity<List<Pedido>> getAll() {
        return ResponseEntity.ok(pedidoService.recuperarTodos());
    }

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> get(@RequestParam Integer id) {
        Pedido pedido = pedidoService.recuperarPeloNumero(id);
        if (pedido != null) {
            return ResponseEntity.ok(pedido);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/pedidos/faturamento/{ano}")
    public ResponseEntity<List<FaturamentoMensal>> getFaturamentoMensal(@PathVariable Integer ano) {
        return ResponseEntity.ok(pedidoService.recuperarFaturamento(ano));
    }
}
