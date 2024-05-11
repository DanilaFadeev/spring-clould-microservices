package org.javastart.notification.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.javastart.notification.config.RabbitMqConfig;
import org.javastart.notification.dto.DepositEventDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class DepositMessageHandler {
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = RabbitMqConfig.QUEUE_DEPOSIT)
    public void receive(Message message) throws IOException {
        System.out.println(message);
        String payload = new String(message.getBody());
        System.out.println(payload);

        DepositEventDto depositEventDto = objectMapper.readValue(message.getBody(), DepositEventDto.class);
        System.out.println(depositEventDto);
    }
}
