package gip.sever.repository;

import gip.sever.domain.Article;
import gip.sever.domain.Cart;
import gip.sever.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAll();
//    @Query("select p from Product p where p.productName like :keyword")
// Optional<List<Article>> findByKeyword(String keyword);
}
