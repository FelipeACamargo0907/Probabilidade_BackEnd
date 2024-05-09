package br.gov.sp.fatec.calculadora.dtos;

public record HistoricoResponse(long id,
            String tipo,
            double valor1,
            double valor2,
            String resultado) {

}
