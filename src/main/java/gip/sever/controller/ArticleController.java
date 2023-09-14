package gip.sever.controller;

import gip.sever.dto.response.ArticleResponse;
import gip.sever.global.response.SuccessResponse;
import gip.sever.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/article")
public class ArticleController {

    private final ArticleService articleService;
    @GetMapping("/all")
    public ResponseEntity<List<ArticleResponse>> getAllarticles() {
        List<ArticleResponse> articles = articleService.getAllarticles();
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<SuccessResponse<List<ArticleResponse>>> getAllArticles() {
        List<ArticleResponse> articles = articleService.getAllarticles();
        SuccessResponse<List<ArticleResponse>> successResponse = SuccessResponse.create("Successfully retrieved articles", articles);
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }
}
