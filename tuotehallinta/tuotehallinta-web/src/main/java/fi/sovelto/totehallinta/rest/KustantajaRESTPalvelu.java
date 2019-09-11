package fi.sovelto.totehallinta.rest;

import fi.sovelto.dao.KirjaRepositorio;
import fi.sovelto.dao.KustantajaRepositorio;
import fi.sovelto.ejb.KirjaPalvelu;
import fi.sovelto.model.Kirja;
import fi.sovelto.model.Kustantaja;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.*;
import java.util.logging.Logger;

@Path("/kustantajat")
public class KustantajaRESTPalvelu {
    @Inject
    private Logger log;

    @Inject
    private Validator validator;

    @Inject
    private KustantajaRepositorio repo;

    @Inject
    private KirjaPalvelu ejb;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kustantaja> kaikkiKustantajat() {
        return repo.findAllEagerly();
    }

    @GET
    @Path("/{id:[0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Kustantaja lookupMemberById(@PathParam("id") long id) {
        Kustantaja kustantaja = repo.findById(id);
        if (kustantaja == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return kustantaja;
    }

    @GET
    @Path("/{id:[0-9]+}/kirjat")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kirja> kustantajanKirjat(@PathParam("id") long id) {
        List<Kirja> kirjat = repo.findKirjatByKustantajaId(id);
        return kirjat;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uusiKustantaja(Kustantaja kustantaja) {
        Response.ResponseBuilder builder = null;
        try {
            validoiKustantaja(kustantaja);
            ejb.luoKustantaja(kustantaja);
//            repo.uusiKustantaja(kustantaja);
            builder = Response.ok(kustantaja); // location headerin asetus...
        } catch (ConstraintViolationException e) {
            builder = rakennaViolationResponse(e.getConstraintViolations());
        } catch (ValidationException e) {
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("url", "Huono url");
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        } catch (Exception e) {
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("virhe", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }
        log.info("Luotu kustantaja: " + kustantaja);
        return builder.build();
    }

    private void validoiKustantaja(Kustantaja kustantaja) throws ConstraintViolationException, ValidationException {
        // Create a bean validator and check for issues.
        Set<ConstraintViolation<Kustantaja>> violations = validator.validate(kustantaja);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
        }
        // Esimerkki omasta, varsin yksinkertaistetusta, validoinnista
        String url = kustantaja.getWebsite();
        if (url == null || url.isEmpty()) return;
        try {
            URI uri = new URI(kustantaja.getWebsite());
        } catch (URISyntaxException e) {
            throw new ValidationException("Huono URI violation");
        }
    }

    private Response.ResponseBuilder rakennaViolationResponse(Set<ConstraintViolation<?>> violations) {
        log.fine("Validation completed. violations found: " + violations.size());

        Map<String, String> responseObj = new HashMap<>();

        for (ConstraintViolation<?> violation : violations) {
            responseObj.put(violation.getPropertyPath().toString(), violation.getMessage());
        }

        return Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
    }

}