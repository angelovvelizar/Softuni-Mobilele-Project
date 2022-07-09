package bg.softuni.web.mobilelele.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "brands")
public class BrandEntity extends BaseEntity {

    @Column(nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
