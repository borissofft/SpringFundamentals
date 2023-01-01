package bg.softuni.mobilele.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {
    private String name;
    private List<Model> models;

    public Brand() {
        this.models = new ArrayList<>();
    }

    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "brand", targetEntity = Model.class,
    fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Brand{");
        sb.append("name='").append(name).append('\'');
        sb.append(", models=").append(models);
        sb.append('}');
        return sb.toString();
    }

}
