package br.com.truedev.ecommerce.service.categoria;

import br.com.truedev.ecommerce.model.Categoria;

import java.util.List;

public interface ICategoriaService {

    public Categoria criarNova(Categoria nova);
    public Categoria alterar(Categoria categoria);
    public List<Categoria> listarTudo();
    public void apagarCategoria(Integer id);
}
