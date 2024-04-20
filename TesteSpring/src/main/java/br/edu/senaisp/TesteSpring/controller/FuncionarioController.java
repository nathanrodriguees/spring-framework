package br.edu.senaisp.TesteSpring.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.TesteSpring.model.Funcionario;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@PostMapping
	public String Insere(@RequestBody Funcionario f) {

		return "POST" + f.getNome();

	}

	@GetMapping("/busca/{id}")
	public int BuscaPorId(@PathVariable int id) {
		return id;
	}

	@DeleteMapping("/del/{id}")
	public String Delete(@PathVariable int id) {
		return "Del";
	}

	@PutMapping("/alter/{id}")
	public String Alter(@RequestBody Funcionario f, @PathVariable int id) {
		return "Alter";
	}

}
