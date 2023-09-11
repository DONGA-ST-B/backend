package gip.sever.controller;

import gip.sever.dto.response.ProductResponse;
import gip.sever.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class ProductController {

    private final ProductService productService;

    @GetMapping("/product/all")
    public ResponseEntity<List<ProductResponse>> getAllProduct() {
        List<ProductResponse> promotions = productService.getAllProducts();
        return new ResponseEntity<>(promotions, HttpStatus.OK);
    }

}
