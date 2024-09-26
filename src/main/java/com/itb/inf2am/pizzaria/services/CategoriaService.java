package com.itb.inf2am.pizzaria.services;

import com.itb.inf2am.pizzaria.model.Categoria;


import java.util.List;

public interface CategoriaService {

    public Categoria salvarCategoria(Categoria categoria);
    public boolean deletarCategoria(Integer id);
    public List<Categoria> listarTodasCategorias();
    public Categoria listarCategoriaPorId(Integer id);
    public Categoria atualizarCategoria(Categoria categoria, Integer id);
    public  List<Categoria> listarTodasCategoriasAtivas();
    public Categoria listarCategoriaPorIdAtiva(Integer id);
    public Categoria deletarCategoriaLogic(Integer id);

}
