# Interceptor-harjoitus

_Huom: tätä harjoituskuvausta ei ole päivitetty tähän projektiin. Se on vain tässä vaiheessa pohjana, ja on tarkoitus muuttaa 
kuvausta osuvammaksi_



2.	Luo projektiin uusi annotaatiotyyppi com.yritys.tuotehallinta.interceptorit.Suorituskyky. Tee tyypistä materiaa-lin mallin mukaan interceptoria kuvaava annotaatio.
3.	Luo projektiin uusi luokka com.yritys.tuotehallinta.interceptorit.SuorituskykyInterceptor.
4.	Lisää seuraavat import-määritykset:

        ```
        import javax.inject.Inject;
        import javax.interceptor.AroundInvoke;
        import javax.interceptor.Interceptor;
        import javax.interceptor.InvocationContext;
        ```
 
5.	Lisää tyypille seuraavat annotaatiot:
        ```
        @Interceptor @Suorituskyky
        ``` 
6.	Kirjoita instanssimuuttuja lokikäsittelyä varten:
        ```
        @Inject private Logger log;
        ``` 
7.	Lisää varsinainen suoritusmetodi:
        ```
        @AroundInvoke
        public Object tarkistusmetodi(InvocationContext kutsukonteksti)
              throws Exception {
        } 
        ``` 
8.	Perustehtävässä varsinainen suoritusmetodi mittaa kutsuun menevän ajan. Jos testausvaiheessa millisekuntitarkkuus ei ole riittävä, voit korvata sen metodikutsulla nanoTime(). Malli:
        ```
        log.info("tarkistusmetodi() alkaa");
        long alkuaika = System.currentTimeMillis();
        Object paluuarvo = kutsukonteksti.proceed();
        long loppuaika = System.currentTimeMillis();
        log.info("Suoritusaika: " + (loppuaika - alkuaika) + " ms");
        return paluuarvo;
        ``` 
9.	Siirry seuraavaksi muokkaamaan EJB-projektin luokkaa TuotehallintapalveluEJB, johon kuuntelijamääritys lisätään. 
10.	Lisää import-määritys annotaatiolle com.yritys.tuotehallinta.interceptorit.Suorituskyky. Lisää kyseinen annotaatio kirjaa päivittävälle metodille:
        ```
        @Override @Suorituskyky
        public Kirja paivitaKirja(Kirja kirja) {
        ...
        ``` 
11.	Asenna komponentti ja testaa. Mitä vielä tarvitaan, jotta interceptor toimisi?
