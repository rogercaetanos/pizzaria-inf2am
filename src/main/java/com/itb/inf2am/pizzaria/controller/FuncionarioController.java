package com.itb.inf2am.pizzaria.controller;


// @Controller      -> Exclusivo para sistemas web
// @RestController  -> Exclusivo para APIS
// @GetMapping:  Complemento da url principal, exclusivo para consultas
// @PostMapping: Complemento da url principal, exclusivo para cadastro (INSERT)


import com.itb.inf2am.pizzaria.model.Categoria;
import com.itb.inf2am.pizzaria.services.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/funcionario")     // @RequestMapping: Mapeamento da url principal
public class FuncionarioController {

    private final CategoriaService categoriaService;

    public FuncionarioController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/categoria")
    public ResponseEntity<List<Categoria>> listarTodasCategorias() {

        return ResponseEntity.ok().body(categoriaService.listarTodasCategorias());
    }


    @PostMapping("/categoria")
    public ResponseEntity<Categoria> salvarCategoria(@RequestBody Categoria categoria) {

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/funcionario/categoria").toUriString());

        return ResponseEntity.created(uri).body(categoriaService.salvarCategoria(categoria));
    }


}
