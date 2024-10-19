package com.psn.common.base;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ListResponse<T> {
    private final List<T> data;

    public ListResponse(List<T> data) {
        this.data = data;
    }
}
