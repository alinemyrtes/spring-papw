package br.unipe.pos.mobile.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unipe.pos.mobile.api.model.Aluno;
import br.unipe.pos.mobile.api.model.Person;

/**
 * This use JpaRepository that extends the PagingAndSortingRepository that extends CRUDRepository.
 */
@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
