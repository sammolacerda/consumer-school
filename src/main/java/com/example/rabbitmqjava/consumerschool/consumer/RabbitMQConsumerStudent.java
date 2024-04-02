package com.example.rabbitmqjava.consumerschool.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.rabbitmqjava.consumerschool.domain.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class RabbitMQConsumerStudent {

    @RabbitListener(queues = "student.queue")
    public void receiveMessage(String message) throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = objectMapper.readValue(message, Student.class);
        log.info("Mensagem studante recebida: {}", message);
        log.info("Aluno(a): {}", student.getName());
    }

}
