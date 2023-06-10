package org.rolling.controller;

import lombok.RequiredArgsConstructor;
import org.rolling.domain.Article;
import org.rolling.domain.RollingPaper;
import org.rolling.dto.AddArticleRequest;
import org.rolling.dto.AddRollingPaperRequest;
import org.rolling.dto.ArticleResponse;
import org.rolling.service.BlogService;
import org.rolling.service.RollingPaperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RollingPaperApiController {
    private final RollingPaperService rollingPaperService;

    @PostMapping("/api/rolling-papers")
    public ResponseEntity<RollingPaper> addRollingPaper(@RequestBody AddRollingPaperRequest request){
        RollingPaper savedRollingPaper = rollingPaperService.save(request);

        //요청한 자원이 성공적으로 생성되었으며 저장된 블로그 글 정보를 응답 객체에 담아 전송
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedRollingPaper);
    }
}
