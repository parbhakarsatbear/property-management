package com.mycompany.Propertymanagement.controller;

import com.mycompany.Propertymanagement.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {

    @GetMapping("/add")
    public Double add(@RequestParam("num1") Double n1, @RequestParam("num2") Double n2){
        return n1+n2;
    }

    @GetMapping("/sub/{num1}/{num2}")
    public Double substract(@PathVariable("num1") Double num1,@PathVariable("num2") Double num2){
        return num1-num2;
    }

    @PostMapping("/mul")
    public ResponseEntity<Double> mul(@RequestBody CalculatorDTO calculatorDTO){
        Double result=null;
        result = calculatorDTO.getNum1()*calculatorDTO.getNum2();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return  responseEntity;
    }
}
