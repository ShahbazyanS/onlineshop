package online.shop.onlineshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
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
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id")
    private ShoppingCart shoppingCart;
    @OneToOne
    private Order order;
    private String token;
}
