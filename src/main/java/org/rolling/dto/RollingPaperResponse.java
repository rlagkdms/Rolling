package org.rolling.dto;

import lombok.Getter;
import org.rolling.domain.RollingPaper;

import java.util.Date;

@Getter
public class RollingPaperResponse {
    private final String title;
    private final String maker;
    private final String receiver;
    private final Date date;


    public RollingPaperResponse(RollingPaper rollingPaper){
        this.title = rollingPaper.getTitle();
        this.maker = rollingPaper.getMaker();
        this.receiver= rollingPaper.getReceiver();
        this.date = rollingPaper.getDate();
    }
}
