package gip.sever.dto.response;

import gip.sever.domain.Article;
import gip.sever.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchResponse {
    private Long id;
    private String title;
    private String imageURL;
    private String content;

    public SearchResponse(Product product) {
        this.id = product.getId();
        this.title = product.getProductName();
        this.imageURL = product.getPhotoUrl();
        this.content = product.getProductName();
    }

    public SearchResponse(Article product) {
        this.id = product.getId();
        this.title = product.getArticleTitle();
        this.imageURL = product.getPhotoUrl();
        this.content = product.getArticleContent();
    }


}
