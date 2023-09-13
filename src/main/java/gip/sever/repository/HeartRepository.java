package gip.sever.repository;

import gip.sever.domain.Heart;
import gip.sever.domain.Member;
import gip.sever.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeartRepository extends JpaRepository<Heart, Long> {
    Heart findByMemberAndProduct(Member member, Product product);
}

