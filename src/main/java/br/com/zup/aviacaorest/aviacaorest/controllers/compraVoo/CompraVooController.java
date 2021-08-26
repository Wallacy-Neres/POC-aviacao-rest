package br.com.zup.aviacaorest.aviacaorest.controllers.compraVoo;


import br.com.zup.aviacaorest.aviacaorest.controllers.compraVoo.converter.SolicitarCompraVooConverter;
import br.com.zup.aviacaorest.aviacaorest.controllers.compraVoo.dto.CompraVooRequest;
import com.zup.aviacao.solicitacao_cadastro_voo.SolicitarCompraVooRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("compra-voo")
@RequiredArgsConstructor
public class CompraVooController {

    private final String topicProducer = "realiza-compra-voo";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    private final SolicitarCompraVooConverter converter;

    @PostMapping
    public ResponseEntity<?> compraVoo(@RequestBody CompraVooRequest request){
        SolicitarCompraVooRequest avro = converter.dtoToAvro(request);
        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(topicProducer, "0", avro);

        log.info("Produzindo mensagem");

        kafkaTemplate.send(producerRecord);

        log.info("SolicitaCompraVoo - FINAL");

        return ResponseEntity.ok("Acho que foi");
    }
}
