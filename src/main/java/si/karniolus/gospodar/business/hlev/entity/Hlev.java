package si.karniolus.gospodar.business.hlev.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * Created by alojz_000 on 20. 11. 2016.
 */
@Entity
@NamedQuery(name = Hlev.findAll, query = "SELECT h FROM Hlev h")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Hlev extends AbstractEntity{
    static final String PREFIX = "hlev.entity.Hlev.";
    public static final String findAll = PREFIX + "findAll";

    @NotNull
    @Size(min = 3, max = 250)
    private String naziv;

    public Hlev() {
    }
    public Hlev(String naziv) {
        this.naziv = naziv;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}