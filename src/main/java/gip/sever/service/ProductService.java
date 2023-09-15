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
import java.util.Optional;
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

    public ProductResponse getProduct(Long productId) throws Exception{
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            ProductResponse productResponse = new ProductResponse();
            productResponse.setId(product.getId());
            productResponse.setProductName(product.getProductName());

            return productResponse;
        } else {
            throw new IllegalArgumentException("Product not found for productId: " + productId);
        }

    }
}
