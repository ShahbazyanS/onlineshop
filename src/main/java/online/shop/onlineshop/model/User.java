package online.shop.onlineshop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    @NotNull
    @OneToOne
    private PersonalInfo personalInfo;
    @NotNull
    @OneToOne
    private ShippingInfo shippingInfo;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "shopping_cart_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ShoppingCart shoppingCart;

    @NotNull
    @OneToOne
    private Order order;
    private String token;


}
