 package com.example.bank.controller;

import com.example.bank.model.BankAccount;
import com.example.bank.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/accounts")
public class BankAccountController {

    @Autowired
    private BankAccountService service;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("accounts", service.findAll());
        return "list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("account", new BankAccount());
        return "form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BankAccount account) {
        service.save(account);
        return "redirect:/accounts";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("account", service.findById(id));
        return "view";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("account", service.findById(id));
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/accounts";
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam Long id, @RequestParam Double amount) {
        service.deposit(id, amount);
        return "redirect:/accounts";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam Long id, @RequestParam Double amount) {
        service.withdraw(id, amount);
        return "redirect:/accounts";
    }
}