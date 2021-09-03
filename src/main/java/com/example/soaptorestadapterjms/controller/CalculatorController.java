package com.example.soaptorestadapterjms.controller;

import com.example.soaptorestadapterjms.amq.MessageProducer;
import com.example.soaptorestadapterjms.dto.RequestDto;
import com.example.soaptorestadapterjms.services.CalculatorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(value = "Адаптер для запросов к dneonline.com/calculator.asmx")
@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private CalculatorService calculatorService;
    private MessageProducer messageProducer;

    public CalculatorController(CalculatorService calculatorService, MessageProducer messageProducer) {
        this.calculatorService = calculatorService;
        this.messageProducer = messageProducer;
    }

    @PostMapping("/add")
    @ApiOperation(value = "Метод возвращает результат сложения двух чисел",
            consumes = "application/json", produces = "text/html")
    public ResponseEntity<?> add(@Validated @RequestBody RequestDto dto,
                                 @RequestHeader("X-Correlation-ID") String correlationId) {

        messageProducer.sendMessage(calculatorService.add(dto), correlationId);
        return new ResponseEntity<>("Request sent", HttpStatus.OK);
    }

    @PostMapping("/divide")
    @ApiOperation(value = "Метод возвращает результат деления двух чисел",
            consumes = "application/json", produces = "text/html")
    public ResponseEntity<?> divide(@Validated @RequestBody RequestDto dto,
                                    @RequestHeader("X-Correlation-ID") String correlationId) {
        if(dto.getIntB() == 0){
            throw new ArithmeticException("Arithmetic exception: division by zero error");
        }
        messageProducer.sendMessage(calculatorService.divide(dto), correlationId);
        return new ResponseEntity<>("Request sent", HttpStatus.OK);
    }

    @PostMapping("/multiply")
    @ApiOperation(value = "Метод возвращает результат умножения двух чисел",
            consumes = "application/json", produces = "text/html")
    public ResponseEntity<?> multiply(@Validated @RequestBody RequestDto dto,
                                      @RequestHeader("X-Correlation-ID") String correlationId) {
        messageProducer.sendMessage(calculatorService.multiply(dto), correlationId);
        return new ResponseEntity<>("Request sent", HttpStatus.OK);
    }

    @PostMapping("/subtract")
    @ApiOperation(value = "Метод возвращает результат вычитания двух чисел",
            consumes = "application/json", produces = "text/html")
    public ResponseEntity<?> subtract(@Validated @RequestBody RequestDto dto,
                                      @RequestHeader("X-Correlation-ID") String correlationId) {
        messageProducer.sendMessage(calculatorService.subtract(dto), correlationId);
        return new ResponseEntity<>("Request sent", HttpStatus.OK);
    }
}