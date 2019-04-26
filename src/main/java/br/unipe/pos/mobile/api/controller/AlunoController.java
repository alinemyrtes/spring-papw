package br.unipe.pos.mobile.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import br.unipe.pos.mobile.api.exception.PersonNotFoundException;
import br.unipe.pos.mobile.api.model.Aluno;
import br.unipe.pos.mobile.api.repository.AlunoRepository;

import javax.validation.Valid;
import java.util.List;

/**
 */
@RestController
@RequestMapping("/api/v1.0")
public class AlunoController {

	@Autowired
	AlunoRepository AlunoRepository;
	
	@GetMapping("/alunos")
	public List<Aluno> getAllAlunos() {
		return AlunoRepository.findAll();
	}

	@GetMapping("/alunos/{id}")
	public Aluno getAlunoById(@PathVariable(value = "id") Long id) {
		return AlunoRepository.findById(id)
				.orElseThrow(() -> new PersonNotFoundException("Aluno", "id", id));
	}

	@PostMapping("/alunos")
	public Aluno createAluno(@Valid @RequestBody Aluno Aluno) {
		return AlunoRepository.save(Aluno);
	}

	@PutMapping("/alunos/{id}")
	public Aluno updateAluno(@PathVariable(value = "id") Long id, @Valid @RequestBody Aluno AlunoDetails) {

		Aluno Aluno = AlunoRepository.findById(id)
				.orElseThrow(() -> new PersonNotFoundException("Aluno", "id", id));

		Aluno.setNome(AlunoDetails.getNome());
		

		Aluno updatedAluno = AlunoRepository.save(Aluno);
		return updatedAluno;
	}

	@DeleteMapping("/alunos/{id}")
	public ResponseEntity<Aluno> deleteAluno(@PathVariable(value = "id") Long id) {

		Aluno Aluno = AlunoRepository.findById(id)
				.orElseThrow(() -> new PersonNotFoundException("Aluno", "id", id));

		AlunoRepository.delete(Aluno);
		return ResponseEntity.ok().build();
	}
}
