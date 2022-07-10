package bg.softuni.web.mobilelele.models.service;

import bg.softuni.web.mobilelele.models.entities.ModelEntity;
import bg.softuni.web.mobilelele.models.entities.enums.Engine;
import bg.softuni.web.mobilelele.models.entities.enums.Transmission;

import java.math.BigDecimal;

public class OfferAddServiceModel {
    private Long id;
    private String description;
    private Engine engine;
    private String imageUrl;
    private Long mileage;
    private BigDecimal price;
    private Transmission transmission;
    private Integer year;
    private ModelEntity model;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public ModelEntity getModel() {
        return model;
    }

    public void setModel(ModelEntity model) {
        this.model = model;
    }
}
