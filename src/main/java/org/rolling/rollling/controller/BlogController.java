package org.rolling.rollling.controller;

import lombok.RequiredArgsConstructor;
import org.rolling.rollling.domain.Article;
import org.rolling.rollling.dto.AddArticleRequest;
import org.rolling.rollling.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController // HTTP 응답 본문에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러
//@Controller   // 응답값에 해당하는 뷰를 매핑하는 컨트롤러
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/api/articles")   // HTTP메서드가 POST이고 url이 /api/articles일 때 매핑된다.
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)    // 201
                .body(savedArticle);    // 저장된 아티클의 정보
    }
}
