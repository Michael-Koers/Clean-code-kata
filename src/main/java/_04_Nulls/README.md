# Avoid returning null
Wanneer methodes geen waarde hebben om terug te geven, wordt er nog wel eens gekozen om `null` terug te geven. 
Dit zorgt echter voor problemen, omdat de aanroepende code dan moet controleren of de waarde `null` is voordat deze gebruikt kan worden.

Dus het introduceren van een `return null` sijpelt door in de rest van de code. 
Daarnaast is het ook nog eens foutgevoelig, als iemand vergeet om te controleren op `null` en de waarde toch gebruikt, dan kan dit leiden tot een `NullPointerException`.

In plaats daarvan is het vaak* beter om een van de volgende opties te gebruiken:
- Een lege collectie teruggeven, zoals een lege lijst of set.
- Een optionele waarde teruggeven, zoals `Optional<T>`.
- Een default waarde teruggeven, zoals een lege string of een standaardwaarde voor een primitief type.


* Reden waarom ik vaak zeg, is omdat `null` soms functionele betekenis heeft, zoals een keuze die nog niet gemaakt is. 
Als je een default waarde teruggeeft, hoe onderscheid je dan nog dat er geen keuze is gemaakt?ß
