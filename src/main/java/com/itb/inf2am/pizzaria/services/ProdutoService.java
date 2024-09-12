package com.itb.inf2am.pizzaria.services;

import com.itb.inf2am.pizzaria.model.Produto;

import java.util.List;

public interface ProdutoService {

    public Produto salvarProduto(Produto produto);
    public boolean deletarProduto(Integer id);
    public List<Produto> listarTodosProdutos();
    public Produto listarProdutoPorId(Integer id);
    public Produto atualizarProduto(Produto produto, Integer id);


}
