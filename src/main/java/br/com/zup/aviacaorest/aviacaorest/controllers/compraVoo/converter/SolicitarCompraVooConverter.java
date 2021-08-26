package br.com.zup.aviacaorest.aviacaorest.controllers.compraVoo.converter;

import br.com.zup.aviacaorest.aviacaorest.controllers.compraVoo.dto.CompraVooRequest;
import com.zup.aviacao.solicitacao_cadastro_voo.SolicitarCompraVooRequest;
import com.zup.aviacao.solicitacao_cadastro_voo.SolicitarCompraVooRequestData;
import org.springframework.stereotype.Component;

@Component
public class SolicitarCompraVooConverter {
    public SolicitarCompraVooRequest dtoToAvro(CompraVooRequest request) {
        return SolicitarCompraVooRequest.newBuilder()
                .setData(
                        SolicitarCompraVooRequestData.newBuilder()
                                .setNomeCliente(request.getNomeCliente())
                                .setCpf(request.getCpf())
                                .setDataNascimento(request.getDataNascimento().toString())
                                .setEmail(request.getEmail())
                                .setSexo(request.getSexo())
                                .setNacionalidade(request.getNacionalidade())
                                .setAssento(request.getAssento())
                                .setCelular(request.getCelular())
                                .setIdVoo(request.getIdVoo())
                                .build()
                )
                .build();
    }
}
