package gip.sever.dto.response;

import gip.sever.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleResponse {
    private Long id;

    private String newspaperName;  // 신문사 이름
    private String articleTitle;   // 기사 제목
    private String articleContent; // 기사 내용
    private String photoUrl;       // 사진 URL(버킷)
    private String articleLink;    // 기사 링크

    public ArticleResponse(Article article){
        this.id =article.getId();
        this.newspaperName=article.getNewspaperName();
        this.articleTitle=article.getArticleTitle();
        this.articleContent=article.getArticleContent();
        this.photoUrl=article.getPhotoUrl();
        this.articleLink=article.getArticleLink();
    }
}
