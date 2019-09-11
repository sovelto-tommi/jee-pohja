# Harjoitus:

Muokkaa pohjaprojektia, ja tee muutoksia oman osaamisesi ja mielenkiintosi mukaisesti.

## Perusharjoitus
Toteuta REST-palvelu Kirjailija-luokalle.
Tee ainakin seuraavat toiminnot 
- GET kaikille, eli hae kaikki
- GET yhdelle, eli hae yksi `id`:n perusteella
- POST, eli uuden kirjailijan lisääminen


## Lisätehtäviä

Seuraavista voit tehdä mitä haluat, missä järjestyksessä vain. 

- Kun haet Kirjailijan, niin palauta myös kyseisen kirjailijan kirjat samassa JSON-dokumentissa 

- Muokkaa Kirja-entiteetin fetchtype EAGER pois   
    - `Kirja.kirjailijat` kentän `@ManyToMany` annotaatiosta
    - Vaatii hieman muutoksia siihen miten yksittäinen kirja haetaan 

- Täydennä Kirja + Kustantaja REST palvelut
    - Lisää enemmän HTML-metodien toteutuksia

- Tarkista että kun lisää koosteisen olion (kirja jolla kustantaja ja/tai kirjailija),
   niin kaikki menevät kantaan