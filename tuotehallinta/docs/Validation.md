# Validation harjoitus

Harjoitus, jossa lisätään validointi kirjan ISBN13 kentälle. 

1. Ohjeet toimivat toivottavasti myös tässä projektissa...
2.	Luo projektin hakemistoon src/main/java aluksi uusi enum-tyyppi nimeltä com.yritys.tuotehallinta.validoijat.IsbnTyyppi. Sisältö:
public enum IsbnTyyppi { ISBN_10, ISBN_13 } 
3.	Luo seuraavaksi uusi annotaatiotyyppi nimeltä com.yritys.tuotehallinta.validoijat.Isbn. 
4.	Luo valmiiksi myös validoinnin logiikkaa varten samaan pakettiin luokka IsbnValidaattori.
5.	Tiedoksesi annotaatiotyypissä tarvittavat import-määritykset:

        ```
        import java.lang.annotation.Documented;
        import java.lang.annotation.ElementType;
        import java.lang.annotation.Retention;
        import java.lang.annotation.RetentionPolicy;
        import java.lang.annotation.Target;
        import javax.validation.Constraint;
        import javax.validation.Payload;
        ``` 
    
6.	Lisää annotaatiotyypille seuraavat annotaatiot (huomaa, että saat toistaiseksi virheilmoituksen IsbnValidaattori-luokan soveltumattomuudesta):

        ```
        @Target({ ElementType.METHOD, ElementType.FIELD, 
                  ElementType.ANNOTATION_TYPE })
        @Retention(RetentionPolicy.RUNTIME)
        @Documented
        @Constraint(validatedBy = IsbnValidaattori.class)
        ```
    
7.	Viimeistele annotaatio kenttätiedoilla:

        ```
           public @interface Isbn {
           String message() default "{com.yritys.tuotehallinta.tark.isbn}";
           Class<?>[] groups() default {};
           Class<? extends Payload>[] payload() default {};
           IsbnTyyppi tyyppi();
        } 
        ```

8.	Lisää virhemerkkijono hakemiston src/main/resources tiedostoon ValidationMessages.properties:
com.yritys.tuotehallinta.tark.isbn=ISBN virheellinen, tarkista muoto 
9.	Siirry vielä viimeistelemään logiikkaluokka IsbnValidaattori. Aseta luokka toteutta-maan paketin javax.validation rajapinta ConstraintValidator<Isbn, String>.
10.	Lisää luokalle instanssimuuttuja, johon tallennetaan tieto ISBN-koodin tyypistä:

        ```
        private IsbnTyyppi isbnTyyppi; 
        ```

11.	Lue arvo alustusmetodissa:

        ```
        @Override
        public void initialize(Isbn annotaatio) {
           this.isbnTyyppi = annotaatio.tyyppi();
        } 
        ```

12.	Toteuta varsinainen logiikka (rajapinnan ConstraintValidatorContext paketti: javax.validation):

        ```
        @Override
        public boolean isValid(String arvo, ConstraintValidatorContext cvc) {
           if (arvo == null) return true;
           if (isbnTyyppi == IsbnTyyppi.ISBN_10) {
              return arvo.length() <= 10;
           } else {
              return arvo.startsWith("978-");
           }
        } 
        ```
       
13.	Nyt validoija on valmis! Lisää validoijan käyttö Kirja-luokan isbn-kentälle: @Isbn(tyyppi = IsbnTyyppi.ISBN_13) 
