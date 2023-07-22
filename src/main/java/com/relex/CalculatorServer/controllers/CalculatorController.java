package com.relex.CalculatorServer.controllers;


import com.relex.CalculatorServer.dto.EvaluationRequestDto;
import com.relex.CalculatorServer.services.EvaluationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class CalculatorController {

    private final EvaluationService evaluationService;

    @PostMapping(value = "/eval",consumes = "application/json")
    public ResponseEntity<String> evaluate(@RequestBody EvaluationRequestDto expression){
        String result = evaluationService.evaluate(expression.getExpression());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
