package org.rolling.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.rolling.domain.User;
import org.rolling.dto.AddUserRequest;
import org.rolling.dto.UpdateUserRequest;
import org.rolling.repository.UserRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    //블로그 글 추가 메서드
    public User save(AddUserRequest request){
        return userRepository.save(request.toEntity());
    }

    //블로그 글 하나 조회( 데이터베이스 id 이용해 글 조회 )
    public User findById(int id){
        return  userRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found: "+id));
    }
    @Transactional
    public User update(int id, UpdateUserRequest request){
        User user = userRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found "+id));

//        article.update(request.getTitle(), request.getContent());

        return user;
    }
    public void delete(long id){
        userRepository.deleteById((int) id);
    }

}
