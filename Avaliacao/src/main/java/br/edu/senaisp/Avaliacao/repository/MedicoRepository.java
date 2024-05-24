package br.edu.senaisp.Avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.senaisp.Avaliacao.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
