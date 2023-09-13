package gip.sever.dto.response;

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
    private String title;
    private String imageURL;
    private String content;

    public SearchResponse(Product product) {
        this.title = product.getProductName();
        this.imageURL = product.getPhotoUrl();
        this.content = product.getProductName();
    }
}
