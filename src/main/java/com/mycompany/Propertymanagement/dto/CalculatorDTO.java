package com.mycompany.Propertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculatorDTO {
    private double num1;
    private double num2;
    private double num3;
    @JsonProperty("num41")
    private double num4;

}
