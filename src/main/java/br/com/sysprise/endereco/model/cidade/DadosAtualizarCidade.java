package br.com.sysprise.endereco.model.cidade;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Optional;

public record DadosAtualizarCidade(@Min(1)
                                   @NotNull(message = "Obrigatório o envio do ID da cidade")
                                   Long id,
                                   String nome,
                                   @Pattern(regexp = "\\d{7}", message = "O padrão esperado é de sete dígitos sem ponto ou traço!")
                                   String codigoIbge,
                                   Optional<Long> estado_id) {
}
