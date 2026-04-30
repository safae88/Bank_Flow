package com.example.bank.controller;

import com.example.bank.service.BankingAgentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AgentController {

    private final BankingAgentService bankingAgentService;

    public AgentController(BankingAgentService bankingAgentService) {
        this.bankingAgentService = bankingAgentService;
    }

    @GetMapping("/agent")
    public String agentPage(Model model) {
        model.addAttribute("question", "");
        model.addAttribute("answer", "");
        return "agent";
    }

    @PostMapping("/agent")
    public String askAgent(@RequestParam(name = "question", required = false) String question, Model model) {
        model.addAttribute("question", question == null ? "" : question);
        model.addAttribute("answer", bankingAgentService.reply(question));
        return "agent";
    }
}

