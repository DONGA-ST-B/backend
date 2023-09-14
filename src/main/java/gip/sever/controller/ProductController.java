package gip.sever.controller;

import gip.sever.domain.Category;
import gip.sever.domain.Product;
import gip.sever.dto.response.ArticleResponse;
import gip.sever.dto.response.ProductResponse;
import gip.sever.global.response.SuccessResponse;
import gip.sever.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static gip.sever.ResponseMessage.GET_ARTICLE_SUCCESS;
import static gip.sever.ResponseMessage.GET_PRODUCT_SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;

    // 카테고리별 제품을 반환하는 엔드포인트
    /*@GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable Category category) {
        return productService.getProductsByCategory(category);
    }*/
    @GetMapping("/category/{category}")
    public ResponseEntity<SuccessResponse<List<ProductResponse>>> getProductsByCategory(@PathVariable Category category) {
        List<ProductResponse> products = productService.getProductsByCategory(category);
        SuccessResponse<List<ProductResponse>> successResponse = SuccessResponse.create(GET_PRODUCT_SUCCESS.getMessage(), products);
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }
}
