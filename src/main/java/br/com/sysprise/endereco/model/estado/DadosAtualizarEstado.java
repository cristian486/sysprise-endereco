package br.com.sysprise.endereco.model.estado;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DadosAtualizarEstado(@Min(1)
                                   @NotNull(message = "Obrigatório o envio do ID do estado")
                                   Long id,
                                   String nome,
                                   @Pattern(regexp = "\\d{7}", message = "O padrão esperado é de sete dígitos sem ponto ou traço!")
                                   String codigoIbge,
                                   @Size(min = 2, max = 2, message = "São esperadas apenas duas letras")
                                   String sigla) {
}
