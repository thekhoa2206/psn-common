package com.psn.common.base;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class PagingFilterRequest {
    private int page = 1;
    private int limit = 20;

    public void setPage(int page) {
        if (page < 1)
            this.page = 1;
        this.page = page;
    }

    public void setLimit(int limit) {
        if (limit < 1)
            this.limit = 1;
        if (limit > 250)
            this.limit = 250;
        this.limit = limit;
    }
}
