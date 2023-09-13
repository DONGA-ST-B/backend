package gip.sever.service;

import gip.sever.domain.Category;
import gip.sever.domain.Product;
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


    public List<ProductResponse> getAllProducts() {
        //리스트로 데이터 넘겨주기
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductResponse::new)
                .collect(Collectors.toList());
    }
    public List<Product> getProductsByCategory(Category category) {
        if (Category.TOTAL.equals(category)) {
            return productRepository.findAll();
        } else {
            return productRepository.findByCategory(category);
        }
    }
}
