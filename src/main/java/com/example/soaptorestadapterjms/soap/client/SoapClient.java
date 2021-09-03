package com.example.soaptorestadapterjms.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class SoapClient extends WebServiceGatewaySupport {

    public Object callWebService(String url, Object request, String action){
        return getWebServiceTemplate().marshalSendAndReceive(url, request, new SoapActionCallback(action));
    }

}
