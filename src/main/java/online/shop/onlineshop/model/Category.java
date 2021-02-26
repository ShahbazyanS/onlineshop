package online.shop.onlineshop.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private Category category;
    @ManyToMany
    @JoinTable(name = "categories_products",
            joinColumns = {@JoinColumn(name = "categories_id")},
            inverseJoinColumns = {@JoinColumn(name = "products_id")})
    private List<Product> sizes;
}
