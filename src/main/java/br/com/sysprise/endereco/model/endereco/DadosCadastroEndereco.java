package br.com.sysprise.endereco.model.endereco;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroEndereco(@NotBlank(message = "Obrigatório o preenchimento da rua")
                                    String rua,
                                    @Min(1)
                                    @NotNull(message = "Obrigatório o envio do número da residência")
                                    Integer numero,
                                    @NotBlank(message = "Obrigatório o preenchimento do bairro")
                                    String bairro,
                                    String complemento,
                                    @Pattern(regexp = "\\d{8}", message = "São esperados oito dígitos sem ponto ou traço!")
                                    String cep,
                                    @Min(1)
                                    @NotNull(message = "Obrigatório o envio do ID da cidade")
                                    Long cidade_id) {
}
