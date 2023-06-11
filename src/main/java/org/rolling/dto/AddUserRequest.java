package org.rolling.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.rolling.domain.User;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddUserRequest {
    private int userNo;
    private String userId;
    private String userPw;
    private String userName;

    public User toEntity() {
        return User.builder()
                .userNo(userNo)
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .build();
    }
}
