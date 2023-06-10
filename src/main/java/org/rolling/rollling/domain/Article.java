package org.rolling.rollling.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity // 엔티티로 지정
@Getter // 게터를 만들어준다
public class Article {
    @Id // id 필드를 기본키로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키가 자동으로 1씩 증가한다
    @Column(name = "id", updatable = false) // 'id'라는 이름을 가진 컬럼과 매칭
    private Long id;

    // null값이 들어갈 수 없다.
    @Column(name = "title", nullable = false) // 'title'라는 이름을 가진 컬럼과 매칭
    private String title;

    @Column(name = "content", nullable = false) // 'id'라는 이름을 가진 컬럼과 매칭
    private String content;
    
    @Builder    // 빌더 패턴을 사용해서 생성자 생성
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
