package com.example.soaptorestadapterjms.amq;

import com.example.soaptorestadapterjms.dto.ResponseDto;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {
    private JmsTemplate jmsTemplate;

    public MessageProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(ResponseDto responseDto, String correlationId){
        jmsTemplate.convertAndSend("calculatorQueue", responseDto, m -> {
            m.setJMSCorrelationID(correlationId);
            return m;
        });
    }
}
