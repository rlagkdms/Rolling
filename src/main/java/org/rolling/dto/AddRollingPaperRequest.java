package org.rolling.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.rolling.domain.RollingPaper;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddRollingPaperRequest {
    private String title;
    private String content;
    private String from;
    private String to;

    public RollingPaper toEntity(){
        return RollingPaper.builder()
                .title(title)
                .content(content)
                .from(from)
                .to(to)
                .date(new Date())
                .build();
    }
}
