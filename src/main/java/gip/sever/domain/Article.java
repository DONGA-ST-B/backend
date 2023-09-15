package gip.sever.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String newspaperName;  // 신문사 이름
    private String articleTitle;   // 기사 제목
    private String articleContent; // 기사 내용
    private String photoUrl;       // 사진 URL(버킷)
    private String articleLink;    // 기사 링크

}

