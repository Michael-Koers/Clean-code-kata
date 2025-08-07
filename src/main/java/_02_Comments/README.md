# Comments

Soms moet je je zelf even afvragen of commentaar in code wel netjes is ingezet, want commentaar kan (onbewust) code smells proberen te verbergen.
Commentaar wordt soms ingezet om andere problemen te voorkomen / op te lossen die eigenlijk met een kleine refactoring opgelost horen te worden.

Commentaar kan soms vervangen worden met:
- Betere variabele namen
- Betere methoden namen
- Simpelweg verwijderen, commentaar is superfluous (legt het overduidelijke uit) of het is code in commentaar
- Een nieuwe utility methode

```java
    int sum(int a, int b){
        // Adds a and b together --> SUPERFLUOUS
        return a + b;
    }
```

Een makkelijke checkvraag die ik mijzelf stel bij schrijven van commentaar: ```Levert dit commentaar toegevoegde waarde op, en probeert het niet iets te verbergen?```

Er zijn natuurlijk nog steeds goede reden om wel commentaar te schrijven:
- JavaDoc
- Beslissingen die anders niet uit code gehaald kan worden

# Opdracht

Loop het commentaar in ```Container.java``` langs en refactor waar nodig, denk aan bovenstaande voorbeelden.

**Extra uitdaging**: Probeer zo min mogelijk handmatige aanpassingen te doen, maar gebruik IntelliJ's ingebouwde refactor methodes, zoals 'Rename Variable' (۩ + F6) en 'Change Signature' (⌘ + F6).
