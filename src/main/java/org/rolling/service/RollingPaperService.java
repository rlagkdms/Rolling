package org.rolling.service;

import lombok.RequiredArgsConstructor;
import org.rolling.domain.RollingPaper;
import org.rolling.dto.AddRollingPaperRequest;
import org.rolling.repository.RollingPaperRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RollingPaperService {
    private final RollingPaperRepository rollingPaperRepository;
    public RollingPaper save(AddRollingPaperRequest request){

        return rollingPaperRepository.save(request.toEntity());
    }
}
