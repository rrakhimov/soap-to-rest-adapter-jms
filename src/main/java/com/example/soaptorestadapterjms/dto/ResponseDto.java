package com.example.soaptorestadapterjms.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel(description = "Dto результата")
public class ResponseDto {
    @ApiModelProperty(notes = "Результат вычисления", example = "3", required = true)
    @NotNull
    private int result;

    public ResponseDto() {
    }

    public ResponseDto(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
