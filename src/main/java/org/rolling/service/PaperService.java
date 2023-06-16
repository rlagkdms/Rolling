package org.rolling.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.rolling.domain.Paper;
import org.rolling.dto.AddPaperRequest;
import org.rolling.dto.UpdatePaperRequest;
import org.rolling.repository.PaperRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PaperService {

    private final PaperRepository paperRepository;

    // 롤링페이퍼 편지 내용 추가 메서드
    public Paper save(AddPaperRequest request) {

        return paperRepository.save(request.toEntity());
    }

    public List<Paper> findAll() {

        return paperRepository.findAll();
    }

    // 편지 글 하나 조회
    public Paper findById(long id) {
        return paperRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+id));
    }

    public void delete(long id) {
        paperRepository.deleteById(id);
    }

    @Transactional
    public Paper update(long id, UpdatePaperRequest request) {
        Paper paper = paperRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: "+id));

        paper.update(request.getPaper_no(), request.getPaper_writer_no(), request.getPaper_content());

        return paper;
    }
}
