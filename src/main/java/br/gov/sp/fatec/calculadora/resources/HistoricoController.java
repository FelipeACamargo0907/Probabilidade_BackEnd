package br.gov.sp.fatec.calculadora.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.gov.sp.fatec.calculadora.dtos.HistoricoRequest;
import br.gov.sp.fatec.calculadora.dtos.HistoricoResponse;
import br.gov.sp.fatec.calculadora.mappers.HistoricoMapper;
import br.gov.sp.fatec.calculadora.services.HistoricoServices;

@RestController 
@RequestMapping("historico")
@CrossOrigin
public class HistoricoController {
    
    @Autowired
    private HistoricoServices service;

    @GetMapping
    public ResponseEntity<List<HistoricoResponse>> getHistorico() {
        var historico = this.service.getHistorico();
        return ResponseEntity.ok(HistoricoMapper.toDTOList(historico));
    }

    @PostMapping
    public ResponseEntity<HistoricoResponse> save(@Validated @RequestBody HistoricoRequest historico) {
        var saveHistorico = this.service.save(historico);


        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveHistorico.id())
                .toUri();
        return ResponseEntity.created(location).body(saveHistorico);
    }

}
