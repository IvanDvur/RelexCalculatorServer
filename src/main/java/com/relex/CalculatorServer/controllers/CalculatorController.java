package com.relex.CalculatorServer.controllers;


import com.relex.CalculatorServer.services.EvaluationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    @Autowired
    private EvaluationService evaluationService;

    @PostMapping(value = "/eval",consumes = "application/json")
    public ResponseEntity<String> evaluate(@RequestBody String expression){
        String result = evaluationService.evaluate(expression);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
