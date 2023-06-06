package br.com.sysprise.endereco.model.cidade;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroCidade(@NotBlank(message = "Obrigatório o preenchimento do nome")
                                  String nome,
                                  @Pattern(regexp = "\\d{7}", message = "O padrão esperado é de sete dígitos sem ponto ou traço!")
                                  String codigoIbge,
                                  @Min(1)
                                  @NotNull(message = "Obrigatório o envio do ID da cidade")
                                  Long estado_id) {
}
