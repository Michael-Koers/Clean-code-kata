# If-statements
Als programmeurs maken we dagelijks gebruik van if-statements, en daar is niets mis mee, maar het wordt een probleem wanneer deze sub-optimaal worden ingezet.
Wat je nog wel eens voorbij ziet komen zijn complexe geneste if-statements die moeilijk te lezen zijn, of zelfs onleesbaar worden. 

Met nesting bedoelen we dat er een if-statement in een andere if-statement zit. Wat het lastig maakt is wanneer logica op verschillende niveau's ingesprongen is, waardoor het moeilijk te lezen is.
De valkuil is om veel/alle logica in een if-statement te stoppen, wat ervoor zorgt dat alle logica indented is. Dat is niet netjes.

Wat je hier tegen kunt doen is de if-statement inverten en/of het introduceren van guard-clauses.

Voorbeeld van inverten:

```java
if (condition) {
    // Heel
    // veel
    // regels    
    // business    
    // logica    
} else {
   return ?;
}
```

omzetten naar:

```java
if (!condition) {
   return ?;
}
// Heel
// veel
// regels    
// business    
// logica    
```

Op deze manier voorkom je dat alle business logica ingesprongen is. Wat je in sommige gevallen waarschijnlijk zult moeten gebruiken zijn Guard-clauses.

# Guard-clauses
Guard clauses zijn conditional statements in het begin van een methode, die foutieve input/situatie's meteen afhandelen.
Je hebt ze vast wel eens gezien als ```Guard.argumentNotNull()``` of ```ObjectUtils.requireNonEmpty()```, je kunt ze in allerlei formaten maken.

Voorbeeld:

```java
public void process(String input) {
    if (input == null || input.isEmpty()) { // Guard clause
        throw new IllegalArgumentException("Input cannot be null or empty");
    }
    
    // Verwerk de input
}
```

Het voordeel van guard-clauses is dat ze de leesbaarheid van de code verbeteren door de foutafhandelingslogica te scheiden van de hoofdlogica van de methode. 
Hierdoor wordt het duidelijker wat de verwachte input is en wat er gebeurt als die input niet aan de verwachtingen voldoet.


# Opdracht

Verwijder alle nesting uit StringUtils terwijl alle unit-testen blijven slagen.

**Extra uitdaging**: Doe geen handmatige aanpassingen, maar gebruik IntelliJ's ingebouwde refactor methodes, zoals Quick-Actions (⌥ + ENTER).

**Optioneel**: Zet "Rerun Automatically" aan in de test-runner, zodat je direct feedback krijgt na een refactorslag

![img.png](img.png)
