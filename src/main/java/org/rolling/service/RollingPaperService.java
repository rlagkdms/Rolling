package org.rolling.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.rolling.domain.RollingPaper;
import org.rolling.dto.AddRollingPaperRequest;
import org.rolling.dto.UpdateRollingPaperRequest;
import org.rolling.repository.RollingPaperRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RollingPaperService {
    private final RollingPaperRepository rollingPaperRepository;
    public RollingPaper save(AddRollingPaperRequest request){
        return rollingPaperRepository.save(request.toEntity());
    }
    public List<RollingPaper> findAll(){
        return rollingPaperRepository.findAll();
    }

    //블로그 글 하나 조회( 데이터베이스 id 이용해 글 조회 )
    public RollingPaper findById(long id){
        return  rollingPaperRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found: "+id));
    }
    @Transactional
    public RollingPaper update(long id, UpdateRollingPaperRequest request){
        RollingPaper rollingPaper = rollingPaperRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found "+id));

//        article.update(request.getTitle(), request.getContent());

        return rollingPaper;
    }
    public void delete(long id){
        rollingPaperRepository.deleteById(id);
    }

}
