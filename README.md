 # BankFlow - Banking Account Management System

BankFlow is a web application developed with Spring Boot MVC for managing bank accounts.  
The application allows users to create, update, delete, and manage bank accounts through a simple and modern web interface.

---

# Features

- Create a bank account
- View all bank accounts
- Update account information
- Delete an account
- Deposit money
- Withdraw money
- View account details
- Responsive interface using Bootstrap 5

---

# Technologies Used

- Java 17
- Spring Boot 3.2.5
- Spring MVC
- Thymeleaf
- Bootstrap 5
- Maven

---

# Project Architecture

The project follows the MVC architecture:

- **Model** → `BankAccount.java`
- **Controller** → `BankAccountController.java`
- **Service** → `BankAccountService.java`
- **View** → Thymeleaf HTML templates

---

# Project Structure

```bash
src/main/
│
├── java/com/example/bank/
│   ├── controller/
│   │   └── BankAccountController.java
│   │
│   ├── model/
│   │   └── BankAccount.java
│   │
│   ├── service/
│   │   └── BankAccountService.java
│   │
│   └── BankApplication.java
│
└── resources/
    ├── templates/
    │   ├── list.html
    │   ├── form.html
    │   └── view.html
    │
    └── application.properties
```

---

# How to Run the Project

## 1. Clone the repository

```bash
git clone https://github.com/safae88/Bank_Flow.git
```

## 2. Open the project folder

```bash
cd Bank_Flow
```

## 3. Run the application

```bash
mvn spring-boot:run
```

## 4. Open in browser

```bash
http://localhost:8080/accounts
```

---

# Main Functionalities

| Method | URL | Description |
|---|---|---|
| GET | `/accounts` | Display all accounts |
| GET | `/accounts/new` | Create account form |
| POST | `/accounts/save` | Save account |
| GET | `/accounts/{id}` | View account details |
| GET | `/accounts/edit/{id}` | Edit account |
| GET | `/accounts/delete/{id}` | Delete account |
| POST | `/accounts/deposit` | Deposit money |
| POST | `/accounts/withdraw` | Withdraw money |

---

# Screenshots

Add your project screenshots here.

---

# Author

**Safae Bouchouicha**

---

# Academic Project

This project was developed as part of a university project using Spring Boot MVC.
