package fi.sovelto.cimcorpdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/hlo")
    public Henkilo helloHenkilo() {
        Henkilo h = new Henkilo();
        h.setEtunimi("Terve");
        h.setSukunimi("Palvelu");
        return h;
    }
}

class Henkilo {
    private String etunimi;
    private String sukunimi;

    public String getEtunimi() {
        return etunimi;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }
}