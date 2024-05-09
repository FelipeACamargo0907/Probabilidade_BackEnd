package br.gov.sp.fatec.calculadora.mappers;

import java.util.List;
import java.util.stream.Collectors;

import br.gov.sp.fatec.calculadora.dtos.HistoricoRequest;
import br.gov.sp.fatec.calculadora.dtos.HistoricoResponse;
import br.gov.sp.fatec.calculadora.entities.Historico;

public class HistoricoMapper {
    public static Historico toEntity(HistoricoRequest request){
        Historico historico = new Historico();
        historico.setTipo(request.tipo());
        historico.setValor1(request.valor1());
        historico.setValor2(request.valor2());
        historico.setResultado(request.resultado());
        return historico;
    }
    public static HistoricoResponse toDTO (Historico historico){
        return new HistoricoResponse(historico.getId(), historico.getTipo(),historico.getValor1(), historico.getValor2(), historico.getResultado());
    }
    public static List<HistoricoResponse> toDTOList(List<Historico> historico){
        return historico.stream().map(HistoricoMapper::toDTO).collect(Collectors.toList());
    }
}
