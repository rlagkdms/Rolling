package org.rolling.rollling.service;

import lombok.RequiredArgsConstructor;
import org.rolling.rollling.domain.Article;
import org.rolling.rollling.dto.AddArticleRequest;
import org.rolling.rollling.repository.BlogRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor    // final이 붙거나 @NotNull이 붙은 필드의 생성자를 추가
@Service    // 빈으로 등록
public class BlogService {


    private final BlogRepository blogRepository;

    /*
    1. 클라이언트에서 글 생성 요청을 보낸다.
    2. AddArticleRequest라는 dto에 매핑이 된다.
    3. AddArticleRequest가 Article 엔티티로 변환이 된다.
    4. BlogRepository에서 실제로 데이터베이스 저장을 하고, 저장된 값을 반환한다.
    5. 응답으로 저장된 값을 보낸다.
     */
    public Article save(AddArticleRequest request) {

        return blogRepository.save(request.toEntity());
    }
}
