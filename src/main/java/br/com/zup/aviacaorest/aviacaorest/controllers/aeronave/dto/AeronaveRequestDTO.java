package br.com.zup.aviacaorest.aviacaorest.controllers.aeronave.dto;

import br.com.zup.aviacaorest.aviacaorest.controllers.assento.AssentoRequestDTO;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AeronaveRequestDTO {

    @NotBlank
    private String marca;

    @NotBlank
    private String modelo;

    private List<AssentoRequestDTO> assentos;
}
