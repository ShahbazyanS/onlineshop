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
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private double price;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "product")
    private List<Images> images;
//    @ManyToOne
//    private ShoppingCart shoppingCart;
    @ManyToMany
    @JoinTable(name = "products_colors",
            joinColumns = {@JoinColumn(name = "products_id")},
            inverseJoinColumns = {@JoinColumn(name = "colors_id")})
    private List<Colors> colors;
    @ManyToMany
    @JoinTable(name = "products_sizes",
            joinColumns = {@JoinColumn(name = "products_id")},
            inverseJoinColumns = {@JoinColumn(name = "sizes_id")})
    private List<Sizes> sizes;
    @ManyToMany
    @JoinTable(name = "products_countries",
            joinColumns = {@JoinColumn(name = "products_id")},
            inverseJoinColumns = {@JoinColumn(name = "countries_id")})
    private List<Countries> countries;
}

