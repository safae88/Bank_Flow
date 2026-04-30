package com.example.bank.service;

import com.example.bank.model.BankAccount;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;

@Service
public class BankingAgentService {

    private static final String BASE_SYSTEM_PROMPT = """
            Vous êtes un conseiller bancaire professionnel. Vous répondez uniquement en français, en vouvoyant systématiquement, avec un ton formel, clair et respectueux.
            
            Vous avez accès à une liste de comptes bancaires internes (ci-dessous). Utilisez-la pour répondre aux questions liées aux comptes (solde, titulaire, identifiant, informations disponibles, opérations possibles dans l’application).
            
            Exigences de qualité:
            - Ne présentez que des informations fondées sur les comptes fournis. Ne fabriquez jamais de comptes, montants, numéros ou dates.
            - Si une information essentielle est manquante (ex: id du compte), posez une question de clarification avant de conclure.
            - Si la demande concerne une action (dépôt/retrait/modification), n’exécutez pas l’opération: décrivez la marche à suivre dans l’application (écran du compte) et les points de vigilance (solde insuffisant, montant positif, etc.).
            - Si la question sort du périmètre (ex: juridique/fiscal/investissement détaillé), répondez prudemment, proposez une orientation générale et recommandez de vérifier auprès d’un conseiller humain.
            
            Format de réponse (court et professionnel):
            - 1 à 2 phrases de contexte / reformulation.
            - Puis des points clairs (si utile): informations constatées, recommandations, prochaines étapes dans l’application.
            - Terminez par une question si un élément manque.
            """;

    private final ChatClient chatClient;
    private final BankAccountService bankAccountService;

    public BankingAgentService(ChatClient.Builder chatClientBuilder, BankAccountService bankAccountService) {
        this.chatClient = chatClientBuilder.build();
        this.bankAccountService = bankAccountService;
    }

    public String reply(String userQuestion) {
        String question = userQuestion == null ? "" : userQuestion.trim();
        if (question.isEmpty()) {
            return "Bonjour. Je vous écoute : quelle est votre question concernant vos comptes ?";
        }

        String accountsContext = buildAccountsContext();

        return chatClient
                .prompt()
                .system(s -> s.text(BASE_SYSTEM_PROMPT + "\n\nComptes disponibles (source interne):\n" + accountsContext))
                .user(question)
                .call()
                .content();
    }

    private String buildAccountsContext() {
        List<BankAccount> accounts = bankAccountService.findAll();
        if (accounts.isEmpty()) {
            return "- Aucun compte n'est enregistré pour le moment.\n";
        }

        accounts.sort(Comparator.comparing(BankAccount::getId));
        StringBuilder sb = new StringBuilder();
        for (BankAccount a : accounts) {
            sb.append("- id=").append(a.getId())
                    .append(", titulaire=").append(nullToDash(a.getAccountHolder()))
                    .append(", numero=").append(maskAccountNumber(a.getAccountNumber()))
                    .append(", solde=").append(a.getBalance() == null ? "-" : String.format(Locale.FRANCE, "%.2f", a.getBalance()))
                    .append(", creeLe=").append(a.getCreatedAt() == null ? "-" : a.getCreatedAt())
                    .append('\n');
        }
        return sb.toString();
    }

    private static String nullToDash(String value) {
        return (value == null || value.isBlank()) ? "-" : value.trim();
    }

    private static String maskAccountNumber(String accountNumber) {
        if (accountNumber == null) {
            return "-";
        }
        String raw = accountNumber.replace(" ", "").trim();
        if (raw.length() <= 6) {
            return raw;
        }
        return raw.substring(0, 2) + "****" + raw.substring(raw.length() - 4);
    }
}

