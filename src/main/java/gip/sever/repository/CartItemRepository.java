package gip.sever.repository;
import gip.sever.domain.Cart;
import gip.sever.domain.CartItem;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    @Query("select ci from CartItem ci where ci.cart.member.id = :memberId and ci.cart.id =:cartId ")
    List<CartItem> findByMemberIdAndCartId( @Param(value = "memberId") Long memberId, @Param(value = "cartId") Long cartId);
}

