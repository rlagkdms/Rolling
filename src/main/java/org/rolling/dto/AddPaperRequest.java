package org.rolling.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.rolling.domain.Paper;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddPaperRequest {

    private String paper_content;

    public Paper toEntity() {
        return Paper.builder()
                .paper_content(paper_content)
                .build();
    }
}
