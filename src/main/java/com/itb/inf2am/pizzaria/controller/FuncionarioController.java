package com.itb.inf2am.pizzaria.controller;


// @Controller      -> Exclusivo para sistemas web
// @RestController  -> Exclusivo para APIS


import com.itb.inf2am.pizzaria.model.Categoria;
import com.itb.inf2am.pizzaria.services.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/funcionario")     // @RequestMapping: Mapeamento da url principal
public class FuncionarioController {

    private final CategoriaService categoriaService;

    public FuncionarioController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/categoria")    // @GetMapping: Complemento da url principal, exclusivo para consultas
    public ResponseEntity<List<Categoria>> listarTodasCategorias() {


        return ResponseEntity.ok().body(categoriaService.listarTodasCategorias());
    }

}
