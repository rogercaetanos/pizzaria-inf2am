package com.itb.inf2am.pizzaria.controller;


// @Controller      -> Exclusivo para sistemas web
// @RestController  -> Exclusivo para APIS
// @RequestMapping  -> Representa a url principal, o endereço do controlador
// @GetMapping:     -> Complemento da url principal, exclusivo para consultas
// @PostMapping:    -> Complemento da url principal, exclusivo para cadastro (INSERT)
// @PutMapping:     -> Complemento da url principal, exclusivo para Atualizar (UPDATE)
// @PathVariable:   -> Indica os parâmetros passados através da url,ou seja, varáveis (tipos primitivos de dados e tbm String)


import com.itb.inf2am.pizzaria.exceptions.BadRequest;
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

        //return ResponseEntity.ok().body(categoriaService.listarTodasCategorias());
        return ResponseEntity.ok().body(categoriaService.listarTodasCategoriasAtivas());
    }


    @GetMapping("/categoria/{id}")
    public ResponseEntity<Categoria> listarCategoriaPorId(@PathVariable(value = "id") String id){
        try {
           // return ResponseEntity.ok().body(categoriaService.listarCategoriaPorId(Integer.parseInt(id)));
            return ResponseEntity.ok().body(categoriaService.listarCategoriaPorIdAtiva(Integer.parseInt(id)));
        }catch(NumberFormatException ex) {
            throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como 15. ");
        }

    }

    @PostMapping("/categoria")
    public ResponseEntity<Categoria> salvarCategoria(@RequestBody Categoria categoria) {

        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/funcionario/categoria").toUriString());

        return ResponseEntity.created(uri).body(categoriaService.salvarCategoria(categoria));
    }

    @PutMapping("/categoria/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@RequestBody Categoria categoria, @PathVariable(value = "id") String id) {
    try{
        return ResponseEntity.ok().body(categoriaService.atualizarCategoria(categoria, Integer.parseInt(id)));

    }catch (NumberFormatException ex) {
        throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como 15. ");
    }

    }

    // Object : Pode representar "qualquer" tipo de objeto : categoria, produto, String, etc...
    @DeleteMapping("/categoria/{id}")
    public ResponseEntity<Object> deletarCategoria(@PathVariable(value = "id") String id) {
        try{
            if(categoriaService.deletarCategoria(Integer.parseInt(id))) {
                return ResponseEntity.ok().body("Categoria com o id " + id + " excluída com sucesso");
            }
        }catch (NumberFormatException ex) {
            throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como 15. ");
        }
        return ResponseEntity.ok().body("Não foi possível a exclusão da categoria com o id " + id);
    }

    @PutMapping("/delete-logic/categoria/{id}")
    public ResponseEntity<Categoria> deletarCategoriaLogic(@PathVariable(value = "id") String id) {
        try{
            return ResponseEntity.ok().body(categoriaService.deletarCategoriaLogic(Integer.parseInt(id)));
        }catch (NumberFormatException ex) {
            throw new BadRequest("'" + id + "' não é um número inteiro válido. Por favor, forneça um valor inteiro, como 15. ");
        }

    }

}
