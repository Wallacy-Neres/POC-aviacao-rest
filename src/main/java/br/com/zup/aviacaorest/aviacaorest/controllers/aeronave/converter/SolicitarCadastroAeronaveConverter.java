package br.com.zup.aviacaorest.aviacaorest.controllers.aeronave.converter;

import br.com.zup.aviacaorest.aviacaorest.controllers.aeronave.dto.AeronaveRequestDTO;
import com.zup.aviacao.solicitacao_cadastro_aeronave.AssentosListaElementos;
import com.zup.aviacao.solicitacao_cadastro_aeronave.SolicitarCadastroAeronaveRequest;
import com.zup.aviacao.solicitacao_cadastro_aeronave.SolicitarCadastroAeronaveRequestData;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class SolicitarCadastroAeronaveConverter {

    public SolicitarCadastroAeronaveRequest dtoToAvro(AeronaveRequestDTO requestDTO) {


        return SolicitarCadastroAeronaveRequest.newBuilder()
                .setData(
                        SolicitarCadastroAeronaveRequestData.newBuilder()
                                .setMarca(requestDTO.getMarca())
                                .setModelo(requestDTO.getModelo())
                                .setAssentos(requestDTO.getAssentos().stream().map(assento -> AssentosListaElementos.newBuilder()
                                        .setNumeroAssento(assento.getNumeroAssento())
                                        .build()).collect(Collectors.toList()))
                                .build()
                )
                .build();
    }
}
