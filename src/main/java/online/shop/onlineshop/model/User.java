package online.shop.onlineshop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String email;
    private String password;
    private boolean active = false;
    @Enumerated(value = EnumType.STRING)
    private UserType userType = UserType.USER;
    @OneToOne
    private PersonalInfo personalInfo;
    @OneToOne
    private ShippingInfo shippingInfo;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "shopping_cart_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ShoppingCart shoppingCart;
    @OneToOne
    private Order order;
    private String token;


}
