package com.itb.inf2am.pizzaria.repository;


import com.itb.inf2am.pizzaria.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
