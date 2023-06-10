package org.rolling.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.rolling.domain.Article;
import org.rolling.dto.AddArticleRequest;
import org.rolling.dto.UpdateArticleRequest;
import org.rolling.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
    }
    public List<Article> findAll(){
        return blogRepository.findAll();
    }

    public Article findById(long id){
        return  blogRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found: "+id));
    }
    @Transactional
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found "+id));

//        article.update(request.getTitle(), request.getContent());

        return article;
    }

}
