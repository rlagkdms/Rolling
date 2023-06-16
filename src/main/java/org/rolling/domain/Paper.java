package org.rolling.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "paper")
public class Paper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rolling_paper_no", updatable = false) // 롤링페이퍼 번호
    private Long id;

    @Column(name = "paper_no", updatable = false) // 롤링페이퍼 안에 있는 각각의 편지 번호
    private Long paper_no;

    @Column(name = "paper_content", nullable = false) // 편지 내용
    private String paper_content;

    @Column(name = "paper_writer_no", updatable = false) // 편지 작성자 넘버
    private Long paper_writer_no;

    @Builder
    public Paper(String paper_content) {
        this.paper_content = paper_content;
    }

    void update(String paper_content) {
        this.paper_content = paper_content;
    }
}
