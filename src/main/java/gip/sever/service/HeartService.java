package gip.sever.service;

import gip.sever.domain.Heart;
import gip.sever.repository.HeartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HeartService {

    private final HeartRepository heartRepository;


    public boolean toggleHeart(Long memberId, Long productId) {
        // memberId와 productId를 사용하여 엔티티 조회
        Heart existingHeart = heartRepository.findByMemberIdAndProductId(memberId, productId);

        if (existingHeart == null) {
            // Heart 엔티티가 없으면 새로운 엔티티를 생성, 저장
            Heart newHeart = new Heart();
            newHeart.setMember_id(memberId);
            newHeart.setProduct_id(productId);
            heartRepository.save(newHeart);
            return true;
        } else {
            // Heart 엔티티가 이미 존재하면 삭제
            heartRepository.delete(existingHeart);
            return false;
        }
    }
}

