package bg.softuni.web.mobilelele.models.entities;

import bg.softuni.web.mobilelele.models.entities.enums.Category;

import javax.persistence.*;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column
    private String url;

    @Column(name = "start_year", nullable = false)
    private Integer startYear;

    @Column(name = "end_year")
    private Integer endYear;

    @ManyToOne
    private BrandEntity brand;

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brandEntity) {
        this.brand = brandEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }
}
