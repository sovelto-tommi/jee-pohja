package fi.sovelto.ejb;

import fi.sovelto.dao.KirjaRepositorio;
import fi.sovelto.dao.KustantajaRepositorio;
import fi.sovelto.model.Kirja;
import fi.sovelto.model.Kustantaja;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class KirjaPalvelu {
    @Inject
    private Logger log;
    @Inject
    private KirjaRepositorio kirjarepo;
    @Inject
    private KustantajaRepositorio kustantajarepo;
    @Inject
    Event<Kirja> kirjaEvent;

    public List<Kirja> haeKirjat() {
        return kirjarepo.findAllOrderedByName();
    }
    public void luoKirja(Kirja kirja) {
        kirjarepo.uusiKirja(kirja);
        kirjaEvent.fire(kirja);
        log.info("Laukaistu..");
    }
    public Kirja poistaKirja(long id) {
        Kirja poistettu = kirjarepo.poistaKirja(id);
        if (poistettu!=null) {
            kirjaEvent.fire(poistettu);
        }
        return poistettu;
    }
    public void luoKustantaja(Kustantaja kustantaja) {
        kustantajarepo.uusiKustantaja(kustantaja);
    }
}
