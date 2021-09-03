package com.example.soaptorestadapterjms.services;

import com.example.soaptorestadapterjms.dto.RequestDto;
import com.example.soaptorestadapterjms.dto.ResponseDto;
import com.example.soaptorestadapterjms.soap.ToEntityConverter;
import com.example.soaptorestadapterjms.soap.client.SoapClient;
import com.example.soaptorestadapterjms.soap.entities.*;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private SoapClient soapClient;
    private ToEntityConverter converter;
    private String url = "http://dneonline.com/calculator.asmx";

    public CalculatorServiceImpl(SoapClient soapClient, ToEntityConverter converter) {
        this.soapClient = soapClient;
        this.converter = converter;
    }

    @Override
    public ResponseDto add(RequestDto requestDto) {
        Add add = converter.toAdd(requestDto);
        AddResponse addResponse = (AddResponse) soapClient.callWebService(url, add,
                "http://tempuri.org/Add");
        return new ResponseDto(addResponse.getAddResult());
    }

    @Override
    public ResponseDto divide(RequestDto requestDto) {
        Divide divide = converter.toDivide(requestDto);
        DivideResponse divideResponse = (DivideResponse) soapClient.callWebService(url, divide,
                "http://tempuri.org/Divide");
        return new ResponseDto(divideResponse.getDivideResult());
    }

    @Override
    public ResponseDto multiply(RequestDto requestDto) {
        Multiply multiply = converter.toMultiply(requestDto);
        MultiplyResponse multiplyResponse = (MultiplyResponse) soapClient.callWebService(url, multiply,
                "http://tempuri.org/Multiply");
        return new ResponseDto(multiplyResponse.getMultiplyResult());
    }

    @Override
    public ResponseDto subtract(RequestDto requestDto) {
        Subtract multiply = converter.toSubtract(requestDto);
        SubtractResponse subtractResponse = (SubtractResponse) soapClient.callWebService(url, multiply,
                "http://tempuri.org/Subtract");
        return new ResponseDto(subtractResponse.getSubtractResult());
    }
}
