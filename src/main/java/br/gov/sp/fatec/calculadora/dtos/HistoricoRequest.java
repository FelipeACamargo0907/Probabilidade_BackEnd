package br.gov.sp.fatec.calculadora.dtos;


public record HistoricoRequest(
    double favoraveis,
    double possiveis,
    String resultado) {
}
