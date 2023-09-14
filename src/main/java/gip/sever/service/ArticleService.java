package gip.sever.service;

import gip.sever.domain.Article;
import gip.sever.domain.Product;
import gip.sever.dto.response.ArticleResponse;
import gip.sever.dto.response.ProductResponse;
import gip.sever.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    public List<ArticleResponse> getAllarticles() {
        //리스트로 데이터 넘겨주기
        List<Article> articles = articleRepository.findAll();
        return articles.stream()
                .map(ArticleResponse::new)
                .collect(Collectors.toList());
    }
}
