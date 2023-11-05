package net.javaguides.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static  final Logger LOGGER= LoggerFactory.getLogger(KafkaProducer.class);
    private KafkaTemplate<String,String> kafkaTemplate;
// if we use SpringBoot it will provide us Kafka template and we don't have to write it, if we use Spring we have to write it
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message){
        LOGGER.info(String.format("Message sent was %s", message));
        kafkaTemplate.send("javaguides",message);
    }
}
