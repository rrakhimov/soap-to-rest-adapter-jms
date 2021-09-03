package com.example.soaptorestadapterjms.services;

import com.example.soaptorestadapterjms.dto.RequestDto;
import com.example.soaptorestadapterjms.dto.ResponseDto;

public interface CalculatorService {
    ResponseDto add(RequestDto requestDto);
    ResponseDto divide(RequestDto requestDto);
    ResponseDto multiply(RequestDto requestDto);
    ResponseDto subtract(RequestDto requestDto);
}
