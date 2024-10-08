package com.mycompany.property_management.controller;

import com.mycompany.property_management.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CalculatorController {

    @GetMapping("/add1")
    public Double add(@RequestParam("num1") Double num1,@RequestParam("num2") Double num2) {
        return num1 + num2;
    }
    @GetMapping("/subtract/{num1}/{num2}")
    public double subtract(@PathVariable("num1") Double num1 , @PathVariable("num2") Double num2){
        Double result = null;
        if(num1>num2){
            result= num1-num2;
        }
        else {
            result= num2-num1;
        }
        return result;
    }

    @PostMapping("/multiply")
    public ResponseEntity<Double> multiply(@RequestBody CalculatorDTO calculatorDTO){
        Double result = null;
        result = calculatorDTO.getNum1()* calculatorDTO.getNum2()* calculatorDTO.getNum3()* calculatorDTO.getNum4();
        ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
        return responseEntity;
    }
}
