package bg.softuni.intro.cats.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "owners")
public class OwnerEntity {
    private Long id;
    private String ownerName;
    private List<CatEntity> cats = new ArrayList<>();

    public OwnerEntity() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    public List<CatEntity> getCats() {
        return cats;
    }

    public void setCats(List<CatEntity> cats) {
        this.cats = cats;
    }

    public OwnerEntity addCat(CatEntity cat) {
        this.cats.add(cat);
        return this;
    }

}
