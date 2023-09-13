package gip.sever.repository;

import gip.sever.domain.GoogleUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoogleUserRepository extends JpaRepository<GoogleUser,Long> {
}
