package si.karniolus.gospodar.business.hlev.boundary;
import si.karniolus.gospodar.business.hlev.entity.Hlev;

import javax.json.JsonObject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by alojz_000 on 20. 11. 2016.
 */
public class HlevResource {

    private long id;
    private HlevManager manager;

    public HlevResource(long id, HlevManager manager) {
        this.id = id;
        this.manager = manager;
    }

    @PUT
    public Hlev save(Hlev hlev) {
        hlev.setId(id);
        return manager.save(hlev);
    }

    @GET
    public Hlev find() {
        return manager.findById(id);
    }

    @DELETE
    public void delete() {
        manager.delete(id);
    }

    @PUT
    @Path("/naziv")
    public Response hlevUpdate(JsonObject statusUpdate) {
        if (!statusUpdate.containsKey("done")) {
            return Response.status(Response.Status.BAD_REQUEST).
                    header("reason", "JSON should contains field done").
                    build();
        }
        String naziv = statusUpdate.getString("naziv");
        Hlev hlev = manager.updateNaziv(id, naziv);
        if (hlev == null) {
            return Response.status(Response.Status.BAD_REQUEST).
                    header("reason", "hlev with id " + id + " does not exist").
                    build();
        } else {
            return Response.ok(hlev).build();
        }
    }
}