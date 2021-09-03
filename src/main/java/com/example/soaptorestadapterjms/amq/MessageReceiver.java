package com.example.soaptorestadapterjms.amq;

import com.example.soaptorestadapterjms.dto.ResponseDto;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

//для проверки
@Component
public class MessageReceiver
{
    private static final String MESSAGE_QUEUE = "calculatorQueue";

    @JmsListener(destination = MESSAGE_QUEUE, selector = "JMSCorrelationID='1234567'")
    public void receiveMessage(ResponseDto responseDto)
    {

        System.out.println("Received result " + responseDto.getResult());
    }
}
