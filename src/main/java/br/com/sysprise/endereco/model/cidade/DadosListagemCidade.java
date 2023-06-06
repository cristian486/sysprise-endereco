package br.com.sysprise.endereco.model.cidade;

public record DadosListagemCidade(Long id, String nome) {

    public DadosListagemCidade(Cidade cidade) {
        this(cidade.getId(), cidade.getNome());
    }
}
