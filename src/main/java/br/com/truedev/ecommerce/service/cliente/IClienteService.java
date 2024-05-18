package br.com.truedev.ecommerce.service.cliente;

import br.com.truedev.ecommerce.model.Cliente;

import java.util.List;

public interface IClienteService {
    public Cliente cadastraNovoCliente(Cliente novo);
    public Cliente alteraCliente(Cliente cliente);
    public Cliente recuperaClientePeloId(Integer id);
    public Cliente recuperaClientePeloTelefone(String telefone);
    public List<Cliente> recuperaTodos();
}
