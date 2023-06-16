package org.rolling.controller;

import lombok.RequiredArgsConstructor;
import org.rolling.domain.Paper;
import org.rolling.dto.AddPaperRequest;
import org.rolling.dto.PaperResponse;
import org.rolling.dto.UpdatePaperRequest;
import org.rolling.service.PaperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/api/papers")
    public ResponseEntity<List<PaperResponse>> findAllPapers() {
        List<PaperResponse> papers = paperService.findAll()
                .stream()
                .map(PaperResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(papers);
    }

    // GET 요청이 오면 해당 id의 편지글 조회
    @GetMapping("/api/papers/{id}")
    public ResponseEntity<PaperResponse> findPaper(@PathVariable long id) {
        Paper paper = paperService.findById(id);

        return ResponseEntity.ok()
                .body(new PaperResponse(paper));
    }

    @DeleteMapping("/api/papers/{id}")
    public ResponseEntity<Void> deletePaper(@PathVariable long id) {
        paperService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/papers/{id}")
    public ResponseEntity<Paper> updatePaper(@PathVariable long id,
                                             @RequestBody UpdatePaperRequest request) {
        Paper updatePaper = paperService.update(id, request);

        return ResponseEntity.ok()
                .body(updatePaper);
    }
}
