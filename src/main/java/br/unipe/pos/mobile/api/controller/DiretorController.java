package br.unipe.pos.mobile.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import br.unipe.pos.mobile.api.exception.PersonNotFoundException;
import br.unipe.pos.mobile.api.model.Diretor;
import br.unipe.pos.mobile.api.repository.DiretorRepository;

import javax.validation.Valid;
import java.util.List;

/**
 */
@RestController
@RequestMapping("/api/v1.0")
public class DiretorController {

	@Autowired
	DiretorRepository DiretorRepository;
	
	@GetMapping("/diretores")
	public List<Diretor> getAllDiretors() {
		return DiretorRepository.findAll();
	}

	@GetMapping("/diretores/{id}")
	public Diretor getDiretorById(@PathVariable(value = "id") Long id) {
		return DiretorRepository.findById(id)
				.orElseThrow(() -> new PersonNotFoundException("Diretor", "id", id));
	}

	@PostMapping("/diretores")
	public Diretor createDiretor(@Valid @RequestBody Diretor Diretor) {
		return DiretorRepository.save(Diretor);
	}

	@PutMapping("/diretores/{id}")
	public Diretor updateDiretor(@PathVariable(value = "id") Long id, @Valid @RequestBody Diretor DiretorDetails) {

		Diretor Diretor = DiretorRepository.findById(id)
				.orElseThrow(() -> new PersonNotFoundException("Diretor", "id", id));

		Diretor.setNome(DiretorDetails.getNome());
		

		Diretor updatedDiretor = DiretorRepository.save(Diretor);
		return updatedDiretor;
	}

	@DeleteMapping("/diretores/{id}")
	public ResponseEntity<Diretor> deleteDiretor(@PathVariable(value = "id") Long id) {

		Diretor Diretor = DiretorRepository.findById(id)
				.orElseThrow(() -> new PersonNotFoundException("Diretor", "id", id));

		DiretorRepository.delete(Diretor);
		return ResponseEntity.ok().build();
	}
}
