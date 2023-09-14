package gip.sever.service;

import gip.sever.domain.Article;
import gip.sever.domain.Category;
import gip.sever.domain.Product;
import gip.sever.dto.response.ArticleResponse;
import gip.sever.dto.response.ProductResponse;
import gip.sever.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public List<ProductResponse> getProductsByCategory(Category category) {
        if (Category.TOTAL.equals(category)) {
            List<Product> products = productRepository.findAll();
            return products.stream()
                    .map(ProductResponse::new)
                    .collect(Collectors.toList());
        } else {
            List<Product> products = productRepository.findByCategory(category);
            return products.stream()
                    .map(ProductResponse::new)
                    .collect(Collectors.toList());
        }
    }

}
