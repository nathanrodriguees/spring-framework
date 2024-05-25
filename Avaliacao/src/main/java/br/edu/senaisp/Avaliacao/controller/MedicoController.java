package br.edu.senaisp.Avaliacao.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.Avaliacao.model.Medico;
import br.edu.senaisp.Avaliacao.repository.MedicoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/hospital")
public class MedicoController {

	@Autowired
	MedicoRepository repository;

	@GetMapping()
	public ResponseEntity<List<Medico>> ListarMedicos() {
		return ResponseEntity.ok(repository.findAll());
	}

//	@GetMapping("/{id}")
//	public Optional<Medico> BuscaPorId(@PathVariable int id) {
//		Optional<Medico> medico = repository.findById(id);
//
//		return medico;
//	}

	@GetMapping("/{id}")
	public ResponseEntity<Medico> BuscaPorId(@PathVariable int id) {
		Optional<Medico> medico = repository.findById(id);

		if (medico.isEmpty())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok(medico.get());
	}

//	@PutMapping("/{id}")
//	public String Altera(@RequestBody Medico medico, @PathVariable int id) {
//
//		Medico tmp = repository.getById(id);
//		tmp.setNome(medico.getNome());
//		tmp.setCrm(medico.getCrm());
//		repository.save(tmp);
//
//		return String.valueOf(tmp);
//	}

//	@PostMapping()
//	public Medico Novo(@RequestBody Medico medico) {
//		repository.save(medico);
//		return medico;
//	}

//	@PutMapping("/{id}")
//	public String Altera(@RequestBody Medico medico, @PathVariable int id) {
//
//		medico.setId(id);
//		medico.setNome(medico.getNome());
//		medico.setCrm(medico.getCrm());
//
//		repository.save(medico);
//
//		return String.valueOf(medico);
//	}

	@PostMapping()
	public ResponseEntity<Medico> Novo(@RequestBody @Valid Medico medico) {
		return ResponseEntity.ok(repository.save(medico));
	}

//	@PutMapping("/{id}")
//	public String Altera(@RequestBody Medico medico, @PathVariable int id) {
//
//		medico.setId(id);
//		medico.setNome(medico.getNome());
//		medico.setCrm(medico.getCrm());
//
//		repository.save(medico);
//
//		return String.valueOf(medico);
//	}

	@PutMapping("/{id}")
	public ResponseEntity<Medico> Altera(@RequestBody @Valid Medico medico, @PathVariable int id) {

		try {
			Medico tmp = repository.findById(id).orElseThrow();
			tmp.setNome(medico.getNome());
			tmp.setCrm(medico.getCrm());
			repository.save(tmp);
			return ResponseEntity.ok(tmp);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

//	@DeleteMapping("/{id}")
//	public void exclui(@PathVariable int id) {
//		repository.deleteById(id);
//	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Medico> excluir(@PathVariable int id) {

		try {
			Medico medico = repository.findById(id).orElseThrow();
			repository.deleteById(id);
			return ResponseEntity.ok(medico);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}
