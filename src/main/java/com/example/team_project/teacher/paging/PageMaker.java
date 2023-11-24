package com.example.team_project.teacher.paging;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class PageMaker {
    private int totalCount;
    private int startPage;
    private int endPage;
    private boolean prev, next;
    private Criteria cri;
    public PageMaker(Criteria cri, int totalCount) {
        this.cri = cri;
        this.totalCount = totalCount;
        this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;
        this.startPage = this.endPage - 9;
        int realEnd = (int) (Math.ceil((totalCount * 1.0) / cri.getAmount()));
        if (realEnd < this.endPage) {
            this.endPage = realEnd;
        }
        this.prev = this.startPage > 1;
        this.next = this.endPage < realEnd;
    }
}
