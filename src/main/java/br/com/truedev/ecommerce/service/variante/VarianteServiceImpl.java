package br.com.truedev.ecommerce.service.variante;

import br.com.truedev.ecommerce.dao.VarianteDAO;
import br.com.truedev.ecommerce.model.Produto;
import br.com.truedev.ecommerce.model.Variante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VarianteServiceImpl implements IVarianteService {

    @Autowired
    private VarianteDAO varianteDAO;

    @Override
    public Variante adicionarNova(Variante nova) {
        return varianteDAO.save(nova);
    }

    @Override
    public Variante alterarDados(Variante variante) {
        return varianteDAO.save(variante);
    }

    @Override
    public List<Variante> recuperarPorProduto(Produto produto) {
        return varianteDAO.findByProduto(produto);
    }

    @Override
    public Variante recuperarPeloId(Integer id) {
        return varianteDAO.findById(id).orElse(null);
    }
}
