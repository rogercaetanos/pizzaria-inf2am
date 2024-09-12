package com.itb.inf2am.pizzaria;

import com.itb.inf2am.pizzaria.model.Produto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PizzariaApplication {

	public static void main(String[] args) {

		SpringApplication.run(PizzariaApplication.class, args);

		System.out.println("Meu primeiro projeto Spring Boot ITB 2024");

		Produto produto = new Produto();
		//produto.setPreco(-60); //  Valor negativo não pode ser atribuído ao preco do produto, precisamos trabalhar com validações
		//System.out.printf("Pizzaria preço: R$ % .2f", produto.getPreco());
		produto.setNome("Pizza de Mussarela");
		produto.setPreco(56.45);
		if(!produto.validarProduto()) {
			System.out.println(produto.getMessage());
		}


	}

}
