package br.com.truedev.ecommerce.service.categoria;

import br.com.truedev.ecommerce.dao.CategoriaDAO;
import br.com.truedev.ecommerce.dao.ClienteDAO;
import br.com.truedev.ecommerce.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaServiceImpl implements ICategoriaService{

    @Autowired
    private CategoriaDAO categoriaDAO;

    @Override
    public Categoria criarNova(Categoria nova) {
        return categoriaDAO.save(nova);
    }

    @Override
    public Categoria alterar(Categoria categoria) {
        return categoriaDAO.save(categoria);
    }

    @Override
    public List<Categoria> listarTudo() {
        return categoriaDAO.findAllByOrderByNomeAsc();
    }

    @Override
    public void apagarCategoria(Integer id) {
        categoriaDAO.deleteById(id);
    }
}
