 package com.example.bank.service;

import com.example.bank.model.BankAccount;
import org.springframework.stereotype.Service;

@Service
public class AgenticService {
    public String getBankAdvice(String name, double balance) {
        if (name == null || name.isBlank()) {
            name = "client";
        }

        if (balance < 1000) {
            return "Augmentez progressivement l'epargne mensuelle pour renforcer la reserve.";
        }
        if (balance < 5000) {
            return "Solde stable: maintenez un plan d'epargne et limitez les retraits non planifies.";
        }
        return "Bonne situation de tresorerie pour " + name + ": diversifiez une partie en epargne a rendement.";
    }
}