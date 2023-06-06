package br.com.sysprise.endereco.model.estado;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"nome", "sigla"})
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String codigoIbge;
    private String sigla;

    public Estado(DadosCadastroEstado dadosCadastro) {
        this.nome = dadosCadastro.nome();
        this.codigoIbge = dadosCadastro.codigoIbge();
        this.sigla = dadosCadastro.sigla();
    }

    public void atualizarCadastro(DadosAtualizarEstado dadosAtualizar) {
        if(dadosAtualizar.nome() != null && !dadosAtualizar.nome().isEmpty())
            this.nome = dadosAtualizar.nome();

        if(dadosAtualizar.codigoIbge() != null && !dadosAtualizar.codigoIbge().isEmpty())
            this.codigoIbge = dadosAtualizar.codigoIbge();

        if(dadosAtualizar.sigla() != null && !dadosAtualizar.sigla().isEmpty())
            this.sigla = dadosAtualizar.sigla();
    }
}
