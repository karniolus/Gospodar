package si.karniolus.gospodar.business.hlev.boundary;

/**
 * Created by alojz_000 on 20. 11. 2016.
 */

import si.karniolus.gospodar.business.hlev.entity.Hlev;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;
import java.util.Random;

@Stateless
@Path("hlevi")
@Produces({MediaType.APPLICATION_JSON})
public class HleviResource {

    @Inject
    HlevManager manager;

    @Path("{id}")
    public HlevResource find(@PathParam("id") long id) {
        return new HlevResource(id, manager);
    }

    @GET
    public List<Hlev> all() {
        return this.manager.all();
    }

    @POST
    public Response save(@Valid Hlev hlev, @Context UriInfo info) {
        Hlev saved = this.manager.save(hlev);
        long id = saved.getId();
        URI uri = info.getAbsolutePathBuilder().path("/" + id).build();
        return Response.created(uri).build();
    }

    @GET
    @Path("/test")
    public Response test(@Context UriInfo info) {
        JsonObjectBuilder entity = Json.createObjectBuilder().
                add("message", "Nekaj je narobe").
                add("type", "error").
                add("data", new Random(100).nextInt(423));


        return Response.status(Response.Status.OK).entity(entity.build()).build();
    }


//    @GET
//    @Path("/objave")
//    public Response dejMiObjave() {
    //WebTarget t = ClientBuilder.newClient().target("https://jsonplaceholder.typicode.com/");
    //PostsResource resource = WebResourceFactory.newResource(PostsResource.class, t);
    //List<Post> posts = resource.getPosts();
//        Client client = ClientBuilder.newClient();
//        WebTarget target = client.target("http://localhost:8080/");
//        MyResourceIfc resource = WebResourceFactory.newResource(MyResourceIfc.class, target);
//
//        String responseFromGet = resource.get();
//        return Response.ok(responseFromGet).build();
//}

}
