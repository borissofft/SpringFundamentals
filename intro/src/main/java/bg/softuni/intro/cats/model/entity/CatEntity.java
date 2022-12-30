package bg.softuni.intro.cats.model.entity;

import javax.persistence.*;
@Entity
@Table(name = "cats")
public class CatEntity {
    private Long id;
    private String catName;
    private OwnerEntity owner;

    public CatEntity() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @ManyToOne
    public OwnerEntity getOwner() {
        return owner;
    }

    public void setOwner(OwnerEntity owner) {
        this.owner = owner;
    }

}
