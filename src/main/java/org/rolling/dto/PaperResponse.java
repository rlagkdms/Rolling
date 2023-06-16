package org.rolling.dto;

import lombok.Getter;
import org.rolling.domain.Paper;

@Getter
public class PaperResponse {

    private final Long paper_no;
    private final Long paper_writer_no;
    private final String paper_content;

    public PaperResponse(Paper paper) {
        this.paper_no = paper.getPaper_no();
        this.paper_writer_no = paper.getPaper_writer_no();
        this.paper_content = paper.getPaper_content();
    }
}
