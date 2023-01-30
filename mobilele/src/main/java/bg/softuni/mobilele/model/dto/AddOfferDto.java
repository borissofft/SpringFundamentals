package bg.softuni.mobilele.model.dto;

import bg.softuni.mobilele.model.enums.Engine;
import bg.softuni.mobilele.model.enums.Transmission;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AddOfferDto {

    private Engine engine;
    private Transmission transmission;
    private String imageUrl;

    public AddOfferDto() {

    }

    @NotNull
    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @NotEmpty
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @NotNull
    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
}
