package br.com.truedev.ecommerce.service.cliente;

import br.com.truedev.ecommerce.model.Cliente;

import java.util.List;

public interface IClienteService {
    Cliente cadastraNovoCliente(Cliente novo);
    Cliente alteraCliente(Cliente cliente);
    Cliente recuperaClientePeloId(Integer id);
    Cliente recuperaClientePeloTelefone(String telefone);
    List<Cliente> recuperaTodos();
}
