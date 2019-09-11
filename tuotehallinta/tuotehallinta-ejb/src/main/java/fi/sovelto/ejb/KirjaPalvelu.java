package fi.sovelto.ejb;

import fi.sovelto.dao.KirjaRepositorio;
import fi.sovelto.dao.KustantajaRepositorio;
import fi.sovelto.model.Kirja;
import fi.sovelto.model.Kustantaja;

import javax.ejb.Stateless;
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

    public List<Kirja> haeKirjat() {
        return kirjarepo.findAllOrderedByName();
    }
    public void luoKustantaja(Kustantaja kustantaja) {
        kustantajarepo.uusiKustantaja(kustantaja);
    }
}
