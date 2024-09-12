package com.itb.inf2am.pizzaria.services;


import com.itb.inf2am.pizzaria.exceptions.BadRequest;
import com.itb.inf2am.pizzaria.exceptions.NotFound;
import com.itb.inf2am.pizzaria.model.Categoria;
import com.itb.inf2am.pizzaria.model.Produto;
import com.itb.inf2am.pizzaria.repository.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    @Transactional
    public Categoria salvarCategoria(Categoria categoria) {
        if(!categoria.validarCategoria()) {
            throw new BadRequest(categoria.getMessage());
        }
        return categoriaRepository.save(categoria);
    }

    @Override
    @Transactional
    public boolean deletarCategoria(Integer id) {

        if(categoriaRepository.existsById(id)){
            categoriaRepository.deleteById(id);
            return true;
        }else {
            throw new NotFound("Categoria não encontrada com o id " + id);
        }

    }
    @Override
    public List<Categoria> listarTodasCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria listarCategoriaPorId(Integer id) {
        try {
            return categoriaRepository.findById(id).get();
        }catch (Exception e) {
            throw new NotFound("Categoria não encontrada com o id " + id);
        }
    }

    @Override
    @Transactional
    public Categoria atualizarCategoria(Categoria categoria, Integer id) {
        try {
            if(!categoria.validarCategoria()){
                throw new BadRequest(categoria.getMessage());
            }
            Categoria categoriaBd = categoriaRepository.findById(id).get();
            categoriaBd.setNome(categoria.getNome());
            categoriaBd.setDescricao(categoria.getDescricao());
            return categoriaRepository.save(categoriaBd); // quando é o mesmo objeto o "save" atualiza (update)
        } catch (Exception e){
            throw new NotFound("Categoria não encontrada com o id " + id);
        }
    }
}
