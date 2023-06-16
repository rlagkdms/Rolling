package org.rolling.service;

import lombok.RequiredArgsConstructor;
import org.rolling.domain.Paper;
import org.rolling.dto.AddPaperRequest;
import org.rolling.repository.PaperRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PaperService {

    private final PaperRepository paperRepository;

    // 롤링페이퍼 편지 내용 추가 메서드
    public Paper save(AddPaperRequest request) {
        return paperRepository.save(request.toEntity());
    }
}
