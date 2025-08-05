# Split state

Wat je nog wel eens ziet gebeuren in software is dat de state en het 'gedrag' van een object verspreid is over meerdere klassen.
In dit voorbeeld zie je dat de state van een Hotel in het Hotel object zit, maar het gedrag van Hotel in een HotelManager.

Het nadeel van een dergelijke opzet is dat:
- De state moet leesbaar zijn (public getters) omdat de HotelManager deze nodig heeft.
- De state moet ook schrijfbaar zijn (public setters) omdat de HotelManager deze moet kunnen aanpassen.
- Je riskeert onnodige extra complexiteit, er is nu niks dat dicteert waar de business logica hoort. Wat kan leiden tot business logica verspreidt over meerdere klassen.

Dit fenomeen ook wel ['Anemic Domain Model'](https://en.wikipedia.org/wiki/Anemic_domain_model), een anti-pattern waarbij domein objecten gereduceerd zijn tot data containers en geen business logica bevatten.

Het liefst wil je de state en gedrag combineren in je domein object, voordelen hiervan zijn:
- Je kunt state volledig encapsuleren, dus geen public getters en setters meer nodig. 
- Je kunt de business logica direct in het domein object plaatsen, waardoor het duidelijker is waar de logica hoort en wat de verantwoordelijkheden zijn.
- Je kunt de state en gedrag beter testen / onderhouden / uitbreiden, omdat ze samen in één object zitten.
- Technische bonus: Hotel kan een record worden, voor minder boilerplate code en immutability bij default.

Met bovenstaande verbeteringen beweeg je meer naar een ['Rich Domain Model'](https://medium.com/@aboutcoding/rich-domain-models-22f176ad6f1b), waarbij domein objecten zowel state als gedrag bevatten.


# Opdracht

Voeg de data van Hotel en de business logica van HotelManager samen in één klasse.

**Extra uitdaging**: probeer zoveel mogelijk IntelliJ's ingebouwde refactor methodes te gebruiken
