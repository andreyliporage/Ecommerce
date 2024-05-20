package br.com.truedev.ecommerce.service.categoria;

import br.com.truedev.ecommerce.model.Categoria;

import java.util.List;

public interface ICategoriaService {

    Categoria criarNova(Categoria nova);
    Categoria alterar(Categoria categoria);
    List<Categoria> listarTudo();
    void apagarCategoria(Integer id);
}
