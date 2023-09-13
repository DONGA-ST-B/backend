package gip.sever.controller;

import gip.sever.domain.Category;
import gip.sever.domain.Product;
import gip.sever.dto.response.ProductResponse;
import gip.sever.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponse>> getAllProduct() {
        List<ProductResponse> promotions = productService.getAllProducts();
        return new ResponseEntity<>(promotions, HttpStatus.OK);
    }
    // 카테고리별 제품을 반환하는 엔드포인트
    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable Category category) {
        return productService.getProductsByCategory(category);
    }
}
