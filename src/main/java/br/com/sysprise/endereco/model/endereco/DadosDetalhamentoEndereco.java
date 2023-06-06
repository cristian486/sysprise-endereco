package br.com.sysprise.endereco.model.endereco;


import br.com.sysprise.endereco.model.cidade.DadosDetalhamentoCidade;

public record DadosDetalhamentoEndereco(Long id, String rua, Integer numero, String bairro,
                                        String complemento, String cep, DadosDetalhamentoCidade cidade) {

    public DadosDetalhamentoEndereco(Endereco endereco) {
        this(endereco.getId(), endereco.getRua(), endereco.getNumero(), endereco.getBairro(),
                endereco.getComplemento(), endereco.getCep(), new DadosDetalhamentoCidade(endereco.getCidade()));
    }
}
