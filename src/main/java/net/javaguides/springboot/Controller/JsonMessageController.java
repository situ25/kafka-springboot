package net.javaguides.springboot.Controller;

import net.javaguides.springboot.kafka.JsonKafkaProducer;
import net.javaguides.springboot.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer JsonKafkaProducer;

    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.JsonKafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String>  publish (@RequestBody User user){
        JsonKafkaProducer.sendMessage(user);
        return  ResponseEntity.ok("JSON message sent to kafka topic");
    }
}
