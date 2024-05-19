package br.com.truedev.ecommerce.service.pedido;

import br.com.truedev.ecommerce.model.Pedido;

import java.util.List;

public interface IPedidoService {

    Pedido criarNovoPedido(Pedido pedido);
    Pedido alterarDados(Pedido pedido);
    List<Pedido> recuperarTodos();
    Pedido recuperarPeloNumero(Integer numPedido);
    List<Pedido> recuperarPorStatus(Integer status);
}
