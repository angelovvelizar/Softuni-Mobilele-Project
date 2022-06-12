package bg.softuni.web.mobilelele.models.views;

import bg.softuni.web.mobilelele.models.entities.Model;
import bg.softuni.web.mobilelele.models.entities.User;
import bg.softuni.web.mobilelele.models.entities.enums.Engine;
import bg.softuni.web.mobilelele.models.entities.enums.Transmission;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
<<<<<<< HEAD
import java.time.Instant;
=======
>>>>>>> 150fdacf9bc2b61e2a16c7b8093b5a0954a0dceb

public class OfferSummaryView {
    private Long id;
    private String description;
    private Engine engine;
    private String imageUrl;
    private Long mileage;
    private BigDecimal price;
    private Transmission transmission;
    private Integer year;
    private String model;
<<<<<<< HEAD
    private Instant created;
    private Instant modified;
    private String seller;
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
=======
>>>>>>> 150fdacf9bc2b61e2a16c7b8093b5a0954a0dceb

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

<<<<<<< HEAD
    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public Instant getModified() {
        return modified;
    }

    public void setModified(Instant modified) {
        this.modified = modified;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

=======
>>>>>>> 150fdacf9bc2b61e2a16c7b8093b5a0954a0dceb
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
