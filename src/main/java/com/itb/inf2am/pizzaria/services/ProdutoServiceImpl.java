package com.itb.inf2am.pizzaria.services;

import com.itb.inf2am.pizzaria.exceptions.BadRequest;
import com.itb.inf2am.pizzaria.exceptions.NotFound;
import com.itb.inf2am.pizzaria.model.Produto;
import com.itb.inf2am.pizzaria.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    // Injeção de dependência utilizando o construtor da classe

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    @Override
    @Transactional
    public Produto salvarProduto(Produto produto) {
    produto.setStatusProd("Ativo");
    if(!produto.validarProduto()) {
        throw new BadRequest(produto.getMessage());
    }
      return produtoRepository.save(produto);
    }

    @Override
    @Transactional
    public boolean deletarProduto(Integer id) {
       if(produtoRepository.existsById(id)){
           produtoRepository.deleteById(id);
           return true;
       }else {
           throw new NotFound("Produto não encontrado com o id " + id);
       }
    }

    @Override
    public List<Produto> listarTodosProdutos() {
        return produtoRepository.findAll();
    }

    // try  -> TENTE FAZER
    // cath -> CAPTURA A EXCEÇÃO SE HOUVER
    @Override
    public Produto listarProdutoPorId(Integer id) {
        try {
            return produtoRepository.findById(id).get();
        }catch (Exception e) {
            throw new NotFound("Produto não encontrado com o id " + id);
        }
    }

    @Override
    @Transactional
    public Produto atualizarProduto(Produto produto, Integer id) {
        try {
            if(!produto.validarProduto()){
                throw new BadRequest(produto.getMessage());
            }
            Produto produtoBd = produtoRepository.findById(id).get();
            produtoBd.setStatusProd(produtoBd.getStatusProd());
            produtoBd.setNome(produto.getNome());
            produtoBd.setPreco(produto.getPreco());
            produtoBd.setDescricao(produto.getDescricao());
            produtoBd.setCodBarras(produto.getCodBarras());

            return produtoRepository.save(produtoBd); // quando é o mesmo objeto o "save" atualiza (update)
        } catch (Exception e){
            throw new NotFound("Produto não encontrado com o id " + id);
        }
    }
}
