package br.com.sysprise.endereco.model.cidade;


import br.com.sysprise.endereco.model.estado.DadosDetalhamentoEstado;

public record DadosDetalhamentoCidade(Long id, String nome, String codigoIbge, DadosDetalhamentoEstado estado) {

    public DadosDetalhamentoCidade(Cidade cidade) {
        this(cidade.getId(), cidade.getNome(), cidade.getCodigoIbge(), new DadosDetalhamentoEstado(cidade.getEstado()));
    }
}
