package bg.softuni.web.mobilelele.models.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand",cascade = CascadeType.ALL)
    private Set<Model> models;

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
