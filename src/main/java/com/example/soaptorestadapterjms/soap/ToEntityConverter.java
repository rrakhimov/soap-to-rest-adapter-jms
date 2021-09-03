package com.example.soaptorestadapterjms.soap;

import com.example.soaptorestadapterjms.dto.RequestDto;
import com.example.soaptorestadapterjms.soap.entities.Add;
import com.example.soaptorestadapterjms.soap.entities.Divide;
import com.example.soaptorestadapterjms.soap.entities.Multiply;
import com.example.soaptorestadapterjms.soap.entities.Subtract;
import org.springframework.stereotype.Component;

@Component
public class ToEntityConverter {
    public Add toAdd(RequestDto requestDto){
        Add add = new Add();
        add.setIntA(requestDto.getIntA());
        add.setIntB(requestDto.getIntB());
        return add;
    }
    public Divide toDivide(RequestDto requestDto){
        Divide divide = new Divide();
        divide.setIntA(requestDto.getIntA());
        divide.setIntB(requestDto.getIntB());
        return divide;
    }

    public Multiply toMultiply(RequestDto requestDto){
        Multiply multiply = new Multiply();
        multiply.setIntA(requestDto.getIntA());
        multiply.setIntB(requestDto.getIntB());
        return multiply;
    }

    public Subtract toSubtract(RequestDto requestDto){
        Subtract subtract = new Subtract();
        subtract.setIntA(requestDto.getIntA());
        subtract.setIntB(requestDto.getIntB());
        return subtract;
    }
}
