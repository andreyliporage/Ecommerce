package br.com.truedev.ecommerce.service.produto;

import br.com.truedev.ecommerce.model.Categoria;
import br.com.truedev.ecommerce.model.Produto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProdutoService {

    Produto cadastrarNovo(Produto novo);
    Produto alterarProdudo(Produto produto);
    Page<Produto> recuperarTodos(int numPagina);
    List<Produto> recuperarPorPalavraChave(String palavraChave);
    List<Produto> buscarPorCategoria(Categoria categoria);
}
