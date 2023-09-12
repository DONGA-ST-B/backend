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
        // memberId와 productId를 사용하여 Heart 엔터티를 조회합니다.
        Heart existingHeart = heartRepository.findByMemberIdAndProductId(memberId, productId);

        if (existingHeart == null) {
            // Heart 엔터티가 없으면 새로운 엔터티를 생성하고 저장합니다.
            Heart newHeart = new Heart();
            newHeart.setMember_id(memberId);
            newHeart.setProduct_id(productId);
            heartRepository.save(newHeart);
            return true; // 버튼이 활성화되었습니다.
        } else {
            // Heart 엔터티가 이미 존재하면 삭제합니다.
            heartRepository.delete(existingHeart);
            return false; // 버튼이 비활성화되었습니다.
        }
    }
}

