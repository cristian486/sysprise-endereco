package br.com.sysprise.endereco.model.estado;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DadosCadastroEstado(@NotBlank(message = "Obrigatório o preenchimento do nome")
                                  String nome,
                                  @Pattern(regexp = "\\d{7}", message = "O padrão esperado é de sete dígitos sem ponto ou traço!")
                                  String codigoIbge,
                                  @Size(min = 2, max = 2, message = "São esperadas apenas duas letras")
                                  @NotBlank(message = "Obrigatório o preenchimento da sigla")
                                  String sigla) {
}
