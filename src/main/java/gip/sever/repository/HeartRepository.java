package gip.sever.repository;

import gip.sever.domain.Heart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeartRepository extends JpaRepository<Heart, Long> {
    Heart findByMemberIdAndProductId(Long memberId, Long productId);
}

