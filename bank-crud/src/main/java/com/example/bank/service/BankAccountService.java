 package com.example.bank.service;

import com.example.bank.model.BankAccount;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BankAccountService {

    private final Map<Long, BankAccount> accounts = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<BankAccount> findAll() {
        return new ArrayList<>(accounts.values());
    }

    public BankAccount findById(Long id) {
        return accounts.get(id);
    }

    public BankAccount save(BankAccount account) {
        if (account.getId() == null) {
            Long id = idGenerator.getAndIncrement();
            account.setId(id);
            account.setCreatedAt(java.time.LocalDateTime.now());
        }
        accounts.put(account.getId(), account);
        return account;
    }

    public void deleteById(Long id) {
        accounts.remove(id);
    }

    public BankAccount deposit(Long id, Double amount) {
        BankAccount account = accounts.get(id);
        if (account != null && amount > 0) {
            account.setBalance(account.getBalance() + amount);
        }
        return account;
    }

    public BankAccount withdraw(Long id, Double amount) {
        BankAccount account = accounts.get(id);
        if (account != null && amount > 0 && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
        }
        return account;
    }
}