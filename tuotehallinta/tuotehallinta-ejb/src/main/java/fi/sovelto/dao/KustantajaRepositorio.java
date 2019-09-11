package fi.sovelto.dao;

import fi.sovelto.model.Kirja;
import fi.sovelto.model.Kustantaja;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class KustantajaRepositorio {
    @Inject
    private EntityManager em;
    @Inject
    Logger log;

    public Kustantaja findById(Long id) {
        return em.find(Kustantaja.class, id);
    }
    public List<Kustantaja> findAllEagerly() {
        Query q = em.createQuery("SELECT k FROM Kustantaja k");
        return q.getResultList();
    }

    public List<Kirja> findKirjatByKustantajaId(Long id) {
        Kustantaja p = em.find(Kustantaja.class, id);
        if (p == null) {
            log.info("Ei kustantajaa idllä " + id);
        }
//        em.detach(p);
        Query q = em.createQuery("SELECT k FROM Kirja k WHERE k.kustantaja = :p");
        q.setParameter("p", p);
        List<Kirja> tulos = q.getResultList();
        return tulos;
    }

    public void uusiKustantaja(Kustantaja kustantaja) {
        em.persist(kustantaja);
    }
}
