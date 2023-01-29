package bg.softuni.mobilele.model.entity;

import bg.softuni.mobilele.model.enums.Category;

import javax.persistence.*;
@Entity
@Table(name = "models")
public class Model extends BaseEntity {
    private String name;
    private Category category;
    private String imageUrl;
    private Integer startYear;
    private Integer endYear;
    private Brand brand;

    public Model() {

    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column()
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "image_url", length = 512)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Column(name = "start_year")
    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    @Column(name = "end_year")
    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    @ManyToOne
    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Model{");
        sb.append("name='").append(name).append('\'');
        sb.append(", category=").append(category);
        sb.append(", imageUrl='").append(imageUrl).append('\'');
        sb.append(", startYear=").append(startYear);
        sb.append(", endYear=").append(endYear);
        sb.append(", brand=").append(brand != null ? brand.getName() : null); // Very important. When we have bidirectional relation its mandatory to get only the name of the other Object
                                                                              // not the all Object. Because if we invoque toString method it will create infinity loop
        sb.append('}');
        return sb.toString();
    }

}
