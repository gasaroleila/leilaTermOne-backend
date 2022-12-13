package com.example.leilatermoneexam.controller;

import com.example.leilatermoneexam.dto.DoMathRequest;
import com.example.leilatermoneexam.util.InvalidOperationException;
import com.example.leilatermoneexam.util.MathOperatorImpl;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    MathOperatorImpl mathOperator;

    @PostMapping("/calculate")
    public ResponseEntity<?> doMath(@RequestBody DoMathRequest dto) throws InvalidOperationException {
        try {
            double result = mathOperator.doMath(dto.getOperand1(), dto.getOperand2(), dto.getOperation());
            return ResponseEntity.ok(result);
        }catch (InvalidOperationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
