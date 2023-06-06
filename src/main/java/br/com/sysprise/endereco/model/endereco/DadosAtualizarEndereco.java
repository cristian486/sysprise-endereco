package br.com.sysprise.endereco.model.endereco;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Optional;

public record DadosAtualizarEndereco(@Min(1)
                                     Long id,
                                     String rua,
                                     Integer numero,
                                     String bairro,
                                     String complemento,
                                     @Pattern(regexp = "\\d{8}", message = "São esperados oito dígitos sem ponto ou traço!")
                                     String cep,
                                     Optional<Long> cidade_id) {
}
