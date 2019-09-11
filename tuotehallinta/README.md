Tuotehallinta - koulutuksen pohjaprojekti
==============================================================================================


## Projekti

Projekti on Maven-pohjainen EAR-projekti, jonka pohjalle voi rakentaa Java EE harjoituksissa pyydettyjä Java EE piirteitä.

Projektin palvelimena toimii Wildfly, testattu versiolla 17. Tietokantana käytetään Wildflyn sisäänrakennettua H2-tietokantaa, ja sen muistipohjaista versiota.


## Ennakkovalmistelut

Projekti tarvitsee 
- Java 8.0 tai uudempi, ainakin 11 kelpaa
- Maven
- Uusi Wildfly versio, ainakin versio 17 toimii


## Wildflyn käynnistys

1. Navigoi komentorivillä asennushakemistoon
2. Käynnistä standalone-versio:

        Windows: JBOSS_HOME\bin\standalone.bat

 
## Pohjaprojektin kääntäminen ja levitys

1. Varmista että Wildfly on käynnissä
2. Käännä ja paketoi `.ear`:

        mvn clean package

3. Tuloksena `tuotehallinta-ear` aliprojektiin `target/tuotehallinta-ear.ear`
4. Joudut _ehkä_ myös asentamaan sovelluksen arkkityypit paikallisesti, varsinkin jos paketointi ei onnistu. Eli saat esimerkiksi virheilmoituksen että web-projektin vaatimaa ejb-riippuvuutta ei löydy

        mvn install
        
5. Nyt voit levittää earin. Seuraava komento vie sen käynnissä olevalle Wildfly-palvelimelle 

        mvn wildfly:deploy

6. Koita onnistuuko kirjojen haku: <http://localhost:8080/tuotehallinta-web/api/kirjat>


## Päivitys

Kaikki seuraavat kun Wildfly on käynnissä
1. Käännös ja levitys (clean vapaaehtoinen)

        mvn clean package wildfly:deploy

2. Paketin poisto palvelimelta:

        mvn wildfly:undeploy

3. Poisto ja uudelleenlevitys

        mvn wildfly:redeploy
 
 
 ## Harjoitukset
 
 Katso myös docs-hakemisto
 