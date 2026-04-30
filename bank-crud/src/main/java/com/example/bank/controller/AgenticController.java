package com.example.bank.controller;

import com.example.bank.service.AgenticService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ai")
public class AgenticController {

    private final AgenticService agenticService;

    public AgenticController(AgenticService agenticService) {
        this.agenticService = agenticService;
    }

    @GetMapping("/advice")
    public String advice(@RequestParam String name, @RequestParam double balance) {
        return agenticService.getBankAdvice(name, balance);
    }
}