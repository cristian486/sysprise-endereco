package br.com.sysprise.endereco.model.cidade;

import br.com.sysprise.endereco.model.estado.Estado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"nome", "estado"})
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String codigoIbge;
    @OneToOne
    private Estado estado;

    public Cidade(DadosCadastroCidade dadosCadastro, Estado estado) {
        this.nome = dadosCadastro.nome();
        this.codigoIbge = dadosCadastro.codigoIbge();
        this.estado = estado;
    }

    public void atualizarCadastro(DadosAtualizarCidade dadosAtualizar) {
        if(dadosAtualizar.nome() != null && !dadosAtualizar.nome().isEmpty())
            this.nome = dadosAtualizar.nome();

        if(dadosAtualizar.codigoIbge() != null && !dadosAtualizar.codigoIbge().isEmpty())
            this.codigoIbge = dadosAtualizar.codigoIbge();
    }

    public void atualizarCadastro(Estado estado) {
        if(!this.estado.getId().equals(estado.getId()))
            this.estado = estado;
    }
}
