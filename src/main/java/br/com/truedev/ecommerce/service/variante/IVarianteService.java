package br.com.truedev.ecommerce.service.variante;

import br.com.truedev.ecommerce.model.Produto;
import br.com.truedev.ecommerce.model.Variante;

import java.util.List;

public interface IVarianteService {
    Variante adicionarNova(Variante nova);
    Variante alterarDados(Variante variante);
    List<Variante> recuperarPorProduto(Produto produto);
    Variante recuperarPeloId(Integer id);
}
