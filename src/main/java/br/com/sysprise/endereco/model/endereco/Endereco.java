package br.com.sysprise.endereco.model.endereco;

import br.com.sysprise.endereco.model.cidade.Cidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"rua", "numero", "complemento"})
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rua;
    private Integer numero;
    private String bairro;
    private String complemento;
    private String cep;
    @OneToOne
    private Cidade cidade;

    public Endereco(pb.CriarEnderecoRequest request, Cidade cidade) {
        this.rua = request.getRua();
        this.numero = request.getNumero();
        this.bairro = request.getBairro();
        this.complemento = request.getComplemento();
        this.cep = request.getCep();
        this.cidade = cidade;
    }

    public void atualizarCadastro(pb.Endereco dadosAtualizar, Cidade cidade) {
        if(!dadosAtualizar.getRua().isEmpty())
            this.rua = dadosAtualizar.getRua();

        if(dadosAtualizar.getNumero() > 0)
            this.numero = dadosAtualizar.getNumero();

        if(!dadosAtualizar.getBairro().isEmpty())
            this.bairro = dadosAtualizar.getBairro();

        if(!dadosAtualizar.getComplemento().isEmpty())
            this.complemento = dadosAtualizar.getComplemento();

        if(!dadosAtualizar.getCep().isEmpty())
            this.cep = dadosAtualizar.getCep();

        if(cidade!= null && !cidade.equals(this.cidade))
            this.cidade = cidade;
    }
}
