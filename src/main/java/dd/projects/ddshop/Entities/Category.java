package dd.projects.ddshop.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@NamedQuery(name = "Category.findByName", query = "select c from Category c where c.name=:name")

@Data
@Entity
@Table(name = "category")
public class Category implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "category_name")
    private String name;
    @Column(name = "category_description")
    private String description;
}
