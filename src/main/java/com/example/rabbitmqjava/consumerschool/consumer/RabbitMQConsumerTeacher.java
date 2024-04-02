package com.example.rabbitmqjava.consumerschool.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.rabbitmqjava.consumerschool.domain.Teacher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RabbitMQConsumerTeacher {

    @RabbitListener(queues = "teacher.queue")
    public void receiveMessage(String message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Teacher teacher = objectMapper.readValue(message, Teacher.class);
        log.info("Mensagem teacher recebida: {}" , message);
        log.info("Professor(a): {}", teacher.getName());
    }
}
