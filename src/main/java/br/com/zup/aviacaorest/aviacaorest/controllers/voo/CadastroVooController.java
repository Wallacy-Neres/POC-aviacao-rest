package br.com.zup.aviacaorest.aviacaorest.controllers.voo;


import br.com.zup.aviacaorest.aviacaorest.controllers.voo.converter.SolicitarCadastroVooConverter;
import br.com.zup.aviacaorest.aviacaorest.controllers.voo.dto.VooRequestDTO;
import com.zup.aviacao.solicitacao_cadastro_voo.SolicitarCadastroVooRequest;
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
@RequestMapping("voo/cadastra")
@RequiredArgsConstructor
public class CadastroVooController {

    private final String topicProducer = "realiza-cadastro-voo";

    private final SolicitarCadastroVooConverter converter;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping
    public ResponseEntity<?> producer(@RequestBody VooRequestDTO request){
        log.info("SolicitarCadastroVoo de VooProducer - INICIO");

        SolicitarCadastroVooRequest avro = converter.dtoToAvro(request);
        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(topicProducer, "0", avro);

        log.info("Produzindo mensagem");

        kafkaTemplate.send(producerRecord);

        log.info("SolicitarCadastro de VooProducer - FINAL");

        return ResponseEntity.ok("Bora ver né");

    }
}
