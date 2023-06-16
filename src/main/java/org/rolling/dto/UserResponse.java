package org.rolling.dto;

import lombok.Getter;
import org.rolling.domain.User;


@Getter
public class UserResponse {
    private final String email;
    private final  String pw;
    private final String name;
    private  final int rolling_paper_no;


    public UserResponse(User user){
        this.email = user.getEmail();
        this.pw = user.getPw();
        this.name = user.getName();
        this.rolling_paper_no = user.getRolling_paper_no();
    }
}
