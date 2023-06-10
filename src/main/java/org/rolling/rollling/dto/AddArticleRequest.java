package org.rolling.rollling.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.rolling.rollling.domain.Article;

@NoArgsConstructor  // 기본생성자를 추가
@AllArgsConstructor // 모든 필드값을 파라미터로 받는 생성자를 추가
@Getter
public class AddArticleRequest {

    private String title;
    private String content;

    public Article toEntity() { // 빌더 패턴을 사용해 객체 생성
        return Article.builder()
                .title(title)   // "오늘의 일기"
                .content(content)   // "내용"
                .build();
    }
}
