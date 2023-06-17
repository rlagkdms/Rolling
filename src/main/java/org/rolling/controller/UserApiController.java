package org.rolling.controller;

import lombok.RequiredArgsConstructor;
import org.rolling.domain.User;
import org.rolling.dto.AddUserRequest;
import org.rolling.dto.UpdateUserRequest;
import org.rolling.dto.UserResponse;
import org.rolling.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;
    @PostMapping("/api/user")
    public ResponseEntity<User> addUser(@RequestBody AddUserRequest request){
        User savedUser = userService.save(request);

        //요청한 자원이 성공적으로 생성되었으며 저장된 블로그 글 정보를 응답 객체에 담아 전송
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedUser);
    }
    @GetMapping("/api/user/{id}")// {id} 해당 값이 long id 로 들어감
    //url 경로에서 값 추출
    public ResponseEntity<UserResponse> findUser(@PathVariable int id){// url 에서 값을 가져옴.
        User user = userService.findById(id);

        return ResponseEntity.ok()
                .body(new UserResponse(user));
    }
    @DeleteMapping("/api/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id){
        userService.delete(id);

        return ResponseEntity.ok()
                .build();
    }
    @PutMapping("/api/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody UpdateUserRequest request){
        // put 요청이 들어오면 request body 정보가 request 로 넘어옴
        User updateUser = userService.update(id,request);

        return ResponseEntity.ok()
                .body(updateUser);
    }
}
