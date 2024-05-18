package br.com.truedev.ecommerce.service.cliente;

import br.com.truedev.ecommerce.dao.ClienteDAO;
import br.com.truedev.ecommerce.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private ClienteDAO clienteDAO;

    @Override
    public Cliente cadastraNovoCliente(Cliente novo) {
        return clienteDAO.save(novo);
    }

    @Override
    public Cliente alteraCliente(Cliente cliente) {
        return clienteDAO.save(cliente);
    }

    @Override
    public Cliente recuperaClientePeloId(Integer id) {
        return clienteDAO.findById(id).orElse(null);
    }

    @Override
    public Cliente recuperaClientePeloTelefone(String telefone) {
        return clienteDAO.findByTelefone(telefone);
    }

    @Override
    public List<Cliente> recuperaTodos() {
        return (List<Cliente>) clienteDAO.findAll();
    }
}
