package br.gov.sp.fatec.calculadora.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.calculadora.dtos.HistoricoRequest;
import br.gov.sp.fatec.calculadora.dtos.HistoricoResponse;
import br.gov.sp.fatec.calculadora.entities.Historico;
import br.gov.sp.fatec.calculadora.mappers.HistoricoMapper;
import br.gov.sp.fatec.calculadora.repositories.HistoricoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class HistoricoServices {
    @Autowired
    private HistoricoRepository repository;

    public List<Historico> getHistorico(){
        return this.repository.findAll();
    }
   
    public HistoricoResponse save(HistoricoRequest historico){
        var entity = this.repository.save(HistoricoMapper.toEntity(historico));
        return HistoricoMapper.toDTO(entity);
    }

    public void update( long id, Historico historico){
        try{
            var updateHistorico = this.repository.getReferenceById(id);
            updateHistorico.setValor1(historico.getValor1());
            updateHistorico.setValor2(historico.getValor2());
            updateHistorico.setResultado(historico.getResultado());
            this.repository.save(updateHistorico);
        }
        catch(EntityNotFoundException e){
            throw new EntityNotFoundException("Historico Not Found");
        }
    }
}
