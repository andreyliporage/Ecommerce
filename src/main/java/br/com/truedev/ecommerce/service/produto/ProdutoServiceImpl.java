package br.com.truedev.ecommerce.service.produto;

import br.com.truedev.ecommerce.dao.ProdutoDAO;
import br.com.truedev.ecommerce.model.Categoria;
import br.com.truedev.ecommerce.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoServiceImpl implements IProdutoService {

    @Autowired
    private ProdutoDAO produtoDAO;

    private static final int PAGE_SIZE = 5;

    @Override
    public Produto cadastrarNovo(Produto novo) {
        return produtoDAO.save(novo);
    }

    @Override
    public Produto alterarProdudo(Produto produto) {
        return produtoDAO.save(produto);
    }

    @Override
    public Page<Produto> recuperarTodos(int numPagina) {
        Pageable pageable = PageRequest.of(numPagina, PAGE_SIZE);
        return produtoDAO.findByOrderByNomeAsc(pageable);
    }

    @Override
    public List<Produto> recuperarPorPalavraChave(String palavraChave) {
        return produtoDAO.findByNomeContaining(palavraChave);
    }

    @Override
    public List<Produto> buscarPorCategoria(Categoria categoria) {
        return produtoDAO.findByCategoriasContaining(categoria);
    }
}
