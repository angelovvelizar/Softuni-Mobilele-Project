package bg.softuni.web.mobilelele.models.bindings;

import bg.softuni.web.mobilelele.models.entities.ModelEntity;
import bg.softuni.web.mobilelele.models.entities.enums.Engine;
import bg.softuni.web.mobilelele.models.entities.enums.Transmission;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class OfferAddBindingModel {

    private Long id;
    @NotBlank
    private String description;
    @NotNull
    private Engine engine;
    @NotBlank
    private String imageUrl;
    @NotNull
    private Long mileage;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Transmission transmission;
    @NotNull
    private Integer year;
    @NotNull
    private String model;

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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
