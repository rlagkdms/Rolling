package org.rolling.controller;

import lombok.RequiredArgsConstructor;
import org.rolling.domain.Paper;
import org.rolling.dto.AddPaperRequest;
import org.rolling.service.PaperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController // HTTP Response Body에 객체 데이터를 JSON형식으로 반환하는 컨트롤러
public class PaperApiController {

    private final PaperService paperService;

    @PostMapping("/api/papers")
    public ResponseEntity<Paper> addPaper(@RequestBody AddPaperRequest request) {
        Paper savedPaper = paperService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedPaper);
    }


}
