package bg.softuni.mobilele.model.entity;

import bg.softuni.mobilele.model.enums.Role;

import javax.persistence.*;
@Entity
@Table(name = "user_roles")
public class UserRole {
    private Long id;
    private Role role;

    public UserRole() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserRole{");
        sb.append("id=").append(id);
        sb.append(", role=").append(role);
        sb.append('}');
        return sb.toString();
    }

}
