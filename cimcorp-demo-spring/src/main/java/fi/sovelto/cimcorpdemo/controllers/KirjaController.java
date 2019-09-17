package fi.sovelto.cimcorpdemo.controllers;

import fi.sovelto.cimcorpdemo.KirjaEvent;
import fi.sovelto.cimcorpdemo.data.KirjaRepositorio;
import fi.sovelto.cimcorpdemo.model.Kirja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/kirjat")
public class KirjaController {
    private KirjaRepositorio kirjaRepositorio;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    private static final Logger logger = Logger.getLogger("KirjaWebSocketHandler");

    public KirjaController(KirjaRepositorio kirjaRepositorio) {
        this.kirjaRepositorio = kirjaRepositorio;
    }

    @GetMapping()
    public Iterable<Kirja> kaikkiKirjat() {
        return kirjaRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> yksiKirja(@PathVariable(name = "id") long id) {
        Optional<Kirja> optKirja = kirjaRepositorio.findById(id);
        if (optKirja.isEmpty()) { // Vaatii JDK 11, vanhemmilla toimii !optKirja.isPresent()
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optKirja.get());
    }
    @PostMapping("")
    public ResponseEntity<?> uusiKirja(@RequestBody Kirja kirja) {
        Kirja talletettu = kirjaRepositorio.save(kirja);
        if (kirja==null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(talletettu.getId()).toUri();
        var kaikkiTiedotAjantasalla = kirjaRepositorio.findById(talletettu.getId());
        KirjaEvent event = new KirjaEvent(this, "Luotu kirja id:llä " + talletettu.getId());
        applicationEventPublisher.publishEvent(event);
        return ResponseEntity.created(location).body(kaikkiTiedotAjantasalla.orElseThrow(RuntimeException::new));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> poistaKirja(@PathVariable(name="id") long id) {
        Optional<Kirja> optKirja = kirjaRepositorio.findById(id);
        if (optKirja.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        kirjaRepositorio.deleteById(id);
        KirjaEvent event = new KirjaEvent(this, "Poistettu kirja id:llä " + id);
        applicationEventPublisher.publishEvent(event);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/poistaminut")
    public Page<Kirja> sivutetut(Pageable pageable) {
        Page<Kirja> sivu = kirjaRepositorio.findAll(pageable);
        return sivu;
    }
}
