package si.karniolus.gospodar.business.client;


import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by alojz_000 on 27. 01. 2017.
 */
public interface PostsResource {
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Post> getPosts();
}