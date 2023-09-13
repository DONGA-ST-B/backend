package gip.sever.repository;

import gip.sever.domain.Category;
import gip.sever.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAll();
    List<Product> findByCategory(Category category);
    @Query("select p from Product p where p.productName like %:keyword%")
    Optional<List<Product>> findByKeyword(@Param("keyword") String keyword);
}
