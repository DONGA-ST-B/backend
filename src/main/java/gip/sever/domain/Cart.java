package gip.sever.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id;

//    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<CartItem> cartItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

//    public void addProduct(Product product) {
//        CartItem cartItem = new CartItem(this, product);
//        cartItems.add(cartItem);
//    }
//
//    public void removeProduct(Product product) {
//        cartItems.removeIf(item -> item.getProduct().equals(product));
//    }
}
