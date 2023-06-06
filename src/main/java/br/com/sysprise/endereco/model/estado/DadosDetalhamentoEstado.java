package br.com.sysprise.endereco.model.estado;

public record DadosDetalhamentoEstado(Long id, String nome, String codigoIbge, String sigla) {

    public DadosDetalhamentoEstado(Estado estado) {
        this(estado.getId(), estado.getNome(), estado.getCodigoIbge(), estado.getSigla());
    }
}
