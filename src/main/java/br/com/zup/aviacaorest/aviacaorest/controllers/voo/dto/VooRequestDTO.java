package br.com.zup.aviacaorest.aviacaorest.controllers.voo.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VooRequestDTO {

    @NotBlank
    private String origem;

    @NotBlank
    private String destino;

    @NotBlank
    private String portao;

    @NotNull
    private LocalTime horaEmbarque;

    @NotNull
    private LocalTime fechaPortao;


    //    @JsonFormat(pattern="dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime dataVoo;

    @NotNull
    private LocalTime tempoDuracao;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotNull
    private Long idAeronave;

}
