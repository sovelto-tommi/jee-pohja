
# React client palvelimille

Web-asiakas, joka toimii kummallekin palvelimelle: Jave EE ja Spring Boot 

## Komponentit

App on ylimmällä tasolla, uudet komponentit `components` hakemistossa.

- App.js

    * Osaksi samaa kuin pohjassa, lataa KirjaKomponentin. Sisältää myös hyvin triviaalin Oma-komponentin
    latauksen
    
- `KirjaKomponentti`

    * "Omistaa" kirjadatan. 
    * `componentDidMount` hakee kirjatiedot REST-palvelusta, sekä avaa WebSocketin
    * `render` näyttää kirjalistan, eli taulukon (_&lt;table&gt;_) `Kirja`-komponentteja, sekä lomakkeen.
    * `uusiKirja` välitetään propsina callback-funktioksi lomakkeelle
    * WebSocketin käsittely: avaus heti, viestin vastaanotto triggeröi kirjalistan päivityksen
    
- `Kirja`

    * Kukin Kirja-komponentti on taulukon rivi (_&lt;tr&gt;_) sisältäen yhden kirjan tietoja

- `KirjaLomake`

    * Yksinkertainen lomake, joka pyytää pari tietoa luotavasta kirjasta, loput kovokoodattuja. 
    * Käyttää propsina saatavaa callback-funktiota hyväksi uuden kirjan tietojen lähettämisesä REST-palvelulle 

## REST client

REST APIn kutsumisen tehdään moduulin `services/kirja-api` avulla. Moduulin funktiot palauttavat 
Promisen, käyttää standardia `fetch`iä sisäisesti 

