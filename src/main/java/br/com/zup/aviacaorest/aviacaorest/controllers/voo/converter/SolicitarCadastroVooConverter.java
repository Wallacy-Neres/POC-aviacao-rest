package br.com.zup.aviacaorest.aviacaorest.controllers.voo.converter;

import br.com.zup.aviacaorest.aviacaorest.controllers.voo.dto.VooRequestDTO;
import com.zup.aviacao.solicitacao_cadastro_voo.SolicitarCadastroVooRequest;
import com.zup.aviacao.solicitacao_cadastro_voo.SolicitarCadastroVooRequestData;
import org.springframework.stereotype.Component;

@Component
public class SolicitarCadastroVooConverter {

    public SolicitarCadastroVooRequest dtoToAvro(VooRequestDTO requestDTO){

        return SolicitarCadastroVooRequest.newBuilder()
                .setData(
                        SolicitarCadastroVooRequestData.newBuilder()
                                .setOrigem(requestDTO.getOrigem())
                                .setDestino(requestDTO.getDestino())
                                .setPortao(requestDTO.getPortao())
                                .setFechaPortao(requestDTO.getFechaPortao().toString())
                                .setHoraEmbarque(requestDTO.getHoraEmbarque().toString())
                                .setDataVoo(requestDTO.getDataVoo().toString())
                                .setTempoDuracao(requestDTO.getTempoDuracao().toString())
                                .setValor(requestDTO.getValor().toString())
                                .setIdAeronave(requestDTO.getIdAeronave())
                                .build()

                ).build();
    }

}
