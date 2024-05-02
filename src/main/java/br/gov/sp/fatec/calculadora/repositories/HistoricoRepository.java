package br.gov.sp.fatec.calculadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.calculadora.entities.Historico;

public interface HistoricoRepository extends JpaRepository<Historico, Long>{
    
}
