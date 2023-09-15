package gip.sever.service;

import gip.sever.domain.Article;
import gip.sever.domain.Product;
import gip.sever.dto.response.SearchResponse;
import gip.sever.repository.ArticleRepository;
import gip.sever.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {

    private final ProductRepository productRepository;
    private final ArticleRepository articleRepository;
    // 기사


    public List<SearchResponse> searchKeyword(String keyword) {

        List<SearchResponse> searchResponses =new ArrayList<>();
        productRepository.findByKeyword(keyword).orElseThrow().stream().forEach(product -> searchResponses.add(new SearchResponse(product)));

        articleRepository.findByKeyword(keyword).orElseThrow().stream().forEach(article -> searchResponses.add(new SearchResponse(article)));


        return searchResponses;


    }
}
