package br.com.zup.aviacaorest.aviacaorest.controllers.compraVoo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompraVooRequest {

    @NotBlank
    private String nomeCliente;

    @NotBlank
    @CPF
    private String cpf;

    @NotNull
    private LocalDate dataNascimento;

    @NotBlank
    private String sexo;

    @NotBlank
    private String nacionalidade;

    @NotBlank
    private String celular;

    @NotBlank
    private String email;

    private String assento;

    @NotNull
    private Long idVoo;
}
