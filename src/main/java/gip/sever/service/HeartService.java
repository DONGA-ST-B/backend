package gip.sever.service;

import gip.sever.domain.Heart;
import gip.sever.domain.Member;
import gip.sever.domain.Product;
import gip.sever.repository.HeartRepository;
import gip.sever.repository.LoginRepository;
import gip.sever.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HeartService {

    private final HeartRepository heartRepository;
    private final ProductRepository productRepository;
    private final LoginRepository loginRepository;


    public boolean toggleHeart(Long memberId, Long productId) {
        // member와 product를 사용하여 엔티티 조회

        Product product = productRepository.findById(productId).orElseThrow();
        Member member = loginRepository.findById(memberId).orElseThrow();
        Heart existingHeart = heartRepository.findByMemberAndProduct(member, product);

        if (existingHeart == null) {
            Heart newHeart = new Heart();
            newHeart.setMember(member);
            newHeart.setProduct(product);
            newHeart.setLiked(true);
            heartRepository.save(newHeart);
            return true;
        } else {
            heartRepository.delete(existingHeart);
            return false;
        }
    }
}

