package com.example.soaptorestadapterjms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel(description = "Dto для запроса")
public class RequestDto {
    @NotNull
    @ApiModelProperty(notes = "Первое число для вычисления", example = "5", required = true)
    private Integer intA;
    @ApiModelProperty(notes = "Второе число для вычисления", example = "2", required = true)
    @NotNull
    private Integer intB;

    public RequestDto() {
    }

    public RequestDto(Integer intA, Integer intB) {
        this.intA = intA;
        this.intB = intB;
    }

    public Integer getIntA() {
        return intA;
    }

    public void setIntA(Integer intA) {
        this.intA = intA;
    }

    public Integer getIntB() {
        return intB;
    }

    public void setIntB(Integer intB) {
        this.intB = intB;
    }
}
