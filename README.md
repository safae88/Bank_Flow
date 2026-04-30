# BankFlow - Gestion des Comptes Bancaires

Application web de gestion des comptes bancaires développée avec Spring Boot MVC.

## Fonctionnalités

- Création de comptes bancaires
- Modification des comptes
- Suppression des comptes
- Consultation des détails d’un compte
- Dépôt d’argent
- Retrait d’argent
- Interface web avec Thymeleaf + Bootstrap

## Technologies Utilisées

- Java 17
- Spring Boot 3
- Spring MVC
- Thymeleaf
- Bootstrap 5
- Maven

## Architecture MVC

Le projet suit l’architecture MVC :

- **Model** → `BankAccount.java`
- **View** → Templates Thymeleaf (`list.html`, `form.html`, `view.html`)
- **Controller** → `BankAccountController.java`
- **Service** → `BankAccountService.java`

## Structure du Projet

```bash
bank-crud/
├── pom.xml
└── src/main/
    ├── java/com/example/bank/
    │   ├── BankApplication.java
    │   ├── model/BankAccount.java
    │   ├── service/BankAccountService.java
    │   └── controller/BankAccountController.java
    └── resources/
        ├── application.properties
        └── templates/
            ├── list.html
            ├── form.html
            └── view.html
