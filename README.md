 # 🏦 BankFlow - Application de gestion bancaire

## 📌 Description

**BankFlow** est une application web développée avec **Spring Boot** permettant de gérer des comptes bancaires et des agents.
Elle implémente les opérations CRUD (Create, Read, Update, Delete) avec une interface web basée sur des pages HTML.

---

## ⚙️ Technologies utilisées

*  Java
*  Spring Boot
*  Spring MVC
*  Maven
*  Thymeleaf (HTML templates)
* Ollama (LLM local)
* Llama 3 (modèle d’intelligence artificielle)

---

## 📁 Structure du projet

```
bank-crud/
│
├── src/
│   └── main/
│       ├── java/com/example/bank/
│       │   ├── controller/
│       │   │   ├── AgentController.java
│       │   │   ├── AgenticController.java
│       │   │   └── BankAccountController.java
│       │   │
│       │   ├── model/
│       │   │   └── BankAccount.java
│       │   │
│       │   ├── service/
│       │   │
│       │   └── BankApplication.java
│       │
│       └── resources/
│           ├── templates/
│           │   ├── agent.html
│           │   ├── form.html
│           │   ├── list.html
│           │   └── view.html
│           │
│           ├── static/
│           └── application.properties
│
├── .mvn/
├── .settings/
└── pom.xml
```

---

## 🚀 Fonctionnalités

*  Gestion des comptes bancaires
*  Gestion des agents
*  Ajout / modification / suppression (CRUD)
*  Affichage via interface web
*  Architecture MVC

---

## ▶️ Lancer le projet

### 1. Cloner le projet

```
git clone https://github.com/ton-repo/bankflow.git
cd bank-crud
```

### 2. Exécuter l'application

```
mvn spring-boot:run
```

Ou lancer directement :

```
BankApplication.java
```

---

## 🌐 Accès

Après démarrage :

```
http://localhost:8081
```

---

## 📄 Pages principales

* `/list` → Liste des comptes
* `/form` → Ajouter / modifier
* `/view` → Détails d’un compte
* `/agent` → Gestion des agents

---

## 📚 Concepts utilisés

* Architecture MVC
* Spring Boot
* Injection de dépendances
* Controllers REST
* Templates Thymeleaf

---

## 👩‍💻 Auteur

**Safae Bouchouicha** **| ****Fouzia Ait Abdenbi**

---

## ✨ Améliorations possibles

* Ajouter Spring Security
*  Utiliser MySQL
*  Ajouter Bootstrap
*  Recherche et pagination
