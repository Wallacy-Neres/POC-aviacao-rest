package br.com.zup.aviacaorest.aviacaorest.controllers.assento;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssentoRequestDTO {

    private String numeroAssento;
}
