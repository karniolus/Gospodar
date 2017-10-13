package si.karniolus.gospodar.business.hlev.boundary;
import si.karniolus.gospodar.business.hlev.entity.Hlev;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;


/**
 * Created by alojz_000 on 20. 11. 2016.
 */
@Stateless
public class HlevManager {

    @PersistenceContext
    EntityManager em;

    public Hlev findById(long id) {
        return this.em.find(Hlev.class, id);

    }

    public void delete(long id) {
        try {
            Hlev reference = this.em.getReference(Hlev.class, id);
            this.em.remove(reference);
        } catch (EntityNotFoundException e) {
            //we want to remove it...
        }
    }

    public List<Hlev> all() {
        return this.em.createNamedQuery(Hlev.findAll, Hlev.class).getResultList();
    }

    public Hlev save(Hlev hlev) {
        Hlev merge = this.em.merge(hlev);
        this.em.flush();
        return merge;
    }

    public Hlev updateNaziv(long id, String naziv) {
        Hlev hlev = this.findById(id);
        if (hlev == null) {
            return null;
        }
        hlev.setNaziv(naziv);
        return hlev;
    }

}