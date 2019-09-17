# Spring Boot palvelin

Spring Boot palvelin, joka on toteutettu tekemään samat asiat kuin Java EE palvelin. Application properties 
sisältää myös kontekstipolun asetuksen:

```
server.servlet.context-path=/tuotehallinta-web
```

## Tärkeimmät piirteet:

- JPA
    - Tietokantana H2 (koodi ensin, alustus data.xml)
    - Entityluokat: Kirja, Kustantaja ja Kirjailija
    - KirjaRepositorio
- RestController
    - GET kirjat ja kirjat/{id}
    - POST kirjat
- WebSocket
    - Kirjan luonti laukaisee tapahtuman (KirjaController)
    - Kuuntelija lähettää viestin kaikille asiakkaille

Sama React client toimii tässä kuin Java EE palvelimella 
