package br.com.zup.aviacaorest.aviacaorest.controllers.aeronave;


import br.com.zup.aviacaorest.aviacaorest.controllers.aeronave.converter.SolicitarCadastroAeronaveConverter;
import br.com.zup.aviacaorest.aviacaorest.controllers.aeronave.dto.AeronaveRequestDTO;
import com.zup.aviacao.solicitacao_cadastro_aeronave.SolicitarCadastroAeronaveRequest;
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
@RequestMapping("aeronave/cadastra")
@RequiredArgsConstructor
public class CadastroAeronaveController {

    private final String topicProducer = "realiza-cadastro-aeronave";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    private final SolicitarCadastroAeronaveConverter converter;

    @PostMapping
    public ResponseEntity<?> producer(@RequestBody AeronaveRequestDTO requestDTO){

        log.info("SolicitarCadastro de AeronaveProducer - INICIO");
        SolicitarCadastroAeronaveRequest avro = converter.dtoToAvro(requestDTO);
        ProducerRecord<String, Object> producerRecord = new ProducerRecord<>(topicProducer, "0", avro);

        log.info("Produzindo mensagem");

        kafkaTemplate.send(producerRecord);

        log.info("SolicitarCadastro de AeronaveProducer - FINAL");

        return ResponseEntity.ok("Deu bom");
    }
}
