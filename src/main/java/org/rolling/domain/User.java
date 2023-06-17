package org.rolling.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no", updatable = false)
    private int id;

    @Column(name = "user_email", nullable = false)
    private String email;

    @Column(name = "user_pw", nullable = false)
    private String pw;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Column(name = "rolling_paper_rolling_paper_no", nullable = false)
    private int rolling_paper_no;


    @Builder//빌더 패턴으로 객체 생성
    public User(int id, String email, String pw, String name, int rolling_paper_no){
        this.id = id;
        this.email = email;
        this.pw = pw;
        this.name = name;
        this.rolling_paper_no = rolling_paper_no;
    }
}
