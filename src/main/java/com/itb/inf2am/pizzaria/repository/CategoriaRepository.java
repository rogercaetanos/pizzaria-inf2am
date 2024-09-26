package com.itb.inf2am.pizzaria.repository;


import com.itb.inf2am.pizzaria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    @Query(value = "SELECT * FROM Categoria c WHERE c.status_cat='ATIVO'", nativeQuery = true)
    public List<Categoria> listarTodasCategoriasAtivas();

    @Query(value = "SELECT * FROM Categoria c WHERE c.id = ?1 AND c.status_cat='ATIVO'", nativeQuery = true)
    public Categoria listarCategoriaPorIdAtiva(Integer id);
}
