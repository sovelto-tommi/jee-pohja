package fi.sovelto.totehallinta.rest;

import fi.sovelto.dao.KirjaRepositorio;
import fi.sovelto.model.Kirja;

import javax.inject.Inject;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Logger;

@Path("/kirjat")
public class KirjaRESTPalvelu {
    @Inject
    private Logger log;

    @Inject
    private Validator validator;

    @Inject
    private KirjaRepositorio repo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Kirja> kaikkiKirjat() {
        return repo.findAllEagerly();
    }
    @GET
    @Path("/{id:[0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Kirja lookupMemberById(@PathParam("id") long id) {
        Kirja kirja = repo.findById(id);
        if (kirja == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return kirja;
    }

}
