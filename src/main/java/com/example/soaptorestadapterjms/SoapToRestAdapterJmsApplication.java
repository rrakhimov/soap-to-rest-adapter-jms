package com.example.soaptorestadapterjms;

import org.apache.activemq.broker.BrokerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class SoapToRestAdapterJmsApplication {

    public static void main(String[] args) throws Exception {
        brokerStart();
        SpringApplication.run(SoapToRestAdapterJmsApplication.class, args);
    }

    public static void brokerStart() throws Exception {
        BrokerService broker = new BrokerService();
        broker.addConnector("tcp://localhost:61616");
        broker.setPersistent(false);
        broker.start();
    }
}
