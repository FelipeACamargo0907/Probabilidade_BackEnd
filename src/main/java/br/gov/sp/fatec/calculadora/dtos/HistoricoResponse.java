package br.gov.sp.fatec.calculadora.dtos;

public record HistoricoResponse(long id,
        double favoraveis,
        double possiveis,
        String resultado) {

}
