package org.rolling.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RollingPaper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paper_id", updatable = false)
    private Long paper_id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "sent_date", nullable = false)
    private Date date;

    @Column(name = "sent_from", nullable = false)
    private String from;

    @Column(name = "sent_to", nullable = false)
    private String to;

    @Column(name = "paper_content", nullable = false) // 편지 내용
    private String paper_content;


    @Builder//빌더 패턴으로 객체 생성
    public RollingPaper(String title, String content, Date date, String from, String to){
        this.title = title;
        this.content = content;
        this.date = date;
        this.from = from;
        this.to = to;
    }
}
