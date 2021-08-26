package br.com.zup.aviacaorest.aviacaorest.controllers.voo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
public class VooResponseDTO {

    private String origem;
    private String destino;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime dataVoo;

    @JsonFormat(pattern = "HH:mm")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime tempoDuracao;
    private BigDecimal valor;


}
