package org.rolling.controller;

import lombok.RequiredArgsConstructor;
import org.rolling.domain.RollingPaper;
import org.rolling.dto.*;
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

    @GetMapping("/api/rolling-papers/{id}")// {id} 해당 값이 long id 로 들어감
    //url 경로에서 값 추출
    public ResponseEntity<RollingPaperResponse> findRollingPaper(@PathVariable long id){// url 에서 값을 가져옴.
        RollingPaper rollingPaper = rollingPaperService.findById(id);

        return ResponseEntity.ok()
                .body(new RollingPaperResponse(rollingPaper));
    }

    @PutMapping("/api/rolling-papers/{id}")
    public ResponseEntity<RollingPaper> updateRollingPaper(@PathVariable long id, @RequestBody UpdateRollingPaperRequest request){
        // put 요청이 들어오면 request body 정보가 request 로 넘어옴
        RollingPaper updateRollingPaper = rollingPaperService.update(id,request);

        return ResponseEntity.ok()
                .body(updateRollingPaper);
    }

//    @DeleteMapping("/api/rolling-papers/{id}")
//    // /api/rollling-papers/{id}를 통해 Delete 요청이 오면 {id}에 해당하는 값이 @PathVariable를 통해 들어옴
//    public ResponseEntity<Void> deleteRollingPaper(@PathVariable long id){
//        rollingPaperService.delete(id);
//
//        return ResponseEntity.ok()
//                .build();
//    }

    // 전체 가져오기
//    @GetMapping("/api/rolling-papers")
//    public ResponseEntity<List<RollingPaperResponse>> findAllRollingPaper(){
//        List<RollingPaperResponse> rollingpapers = rollingPaperService.findAll()
//                .stream()
//                .map(RollingPaperResponse::new)
//                .toList();
//
//        return ResponseEntity.ok()
//                .body(rollingpapers);
//    }
}
