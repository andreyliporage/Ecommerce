package br.com.truedev.ecommerce.service.pedido;

import br.com.truedev.ecommerce.dao.PedidoDAO;
import br.com.truedev.ecommerce.model.ItemPedido;
import br.com.truedev.ecommerce.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoServiceImpl implements IPedidoService {

    @Autowired
    private PedidoDAO pedidoDAO;

    @Override
    public Pedido criarNovoPedido(Pedido pedido) {
        pedido.setStatus(1);
        for (ItemPedido item: pedido.getItens()) {
            item.setPedido(pedido);
        }

        double total = 0.0, desconto = 0.0;
        for (ItemPedido item: pedido.getItens()) {
            total += item.getValorTotal();
        }
        pedido.setValorBruto(total);

        if (total >= 30.0) {
            desconto = total * 0.10;
        }
        total = total - desconto;

        pedido.setDesconto(desconto);
        pedido.setValorTotal(total);
        return pedidoDAO.save(pedido);
    }

    @Override
    public Pedido alterarDados(Pedido pedido) {
        return pedidoDAO.save(pedido);
    }

    @Override
    public List<Pedido> recuperarTodos() {
        return (List<Pedido>) pedidoDAO.findAll();
    }

    @Override
    public Pedido recuperarPeloNumero(Integer numPedido) {
        return pedidoDAO.findById(numPedido).orElse(null);
    }

    @Override
    public List<Pedido> recuperarPorStatus(Integer status) {
        return pedidoDAO.findAllByStatus(status);
    }
}
