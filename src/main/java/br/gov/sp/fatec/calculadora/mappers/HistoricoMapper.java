package br.gov.sp.fatec.calculadora.mappers;

import java.util.List;
import java.util.stream.Collectors;

import br.gov.sp.fatec.calculadora.dtos.HistoricoRequest;
import br.gov.sp.fatec.calculadora.dtos.HistoricoResponse;
import br.gov.sp.fatec.calculadora.entities.Historico;

public class HistoricoMapper {
    public static Historico toEntity(HistoricoRequest request){
        Historico historico = new Historico();
        historico.setFavoraveis(request.favoraveis());
        historico.setPossiveis(request.possiveis());
        historico.setResultado(request.resultado());
        return historico;
    }
    public static HistoricoResponse toDTO (Historico historico){
        return new HistoricoResponse(historico.getId(), historico.getFavoraveis(), historico.getPossiveis(), historico.getResultado());
    }
    public static List<HistoricoResponse> toDTOList(List<Historico> historico){
        return historico.stream().map(HistoricoMapper::toDTO).collect(Collectors.toList());
    }
}
