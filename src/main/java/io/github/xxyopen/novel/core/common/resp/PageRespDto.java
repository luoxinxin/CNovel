package io.github.xxyopen.novel.core.common.resp;

import lombok.Getter;

import java.util.List;

@Getter
public class PageRespDto<T> {
    private final long pageNum;

    private final long pageSize;

    private final long total;

    private final List<? extends T> list;


    public PageRespDto(long pageNum, long pageSize, long total, List<? extends T> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.list = list;
    }

    public static <T> PageRespDto<T> of(long pageNum, long pageSize, long total, List<T> list) {
        return new PageRespDto<>(pageNum, pageSize, total,list);
    }

    public long getPages() {
        if (this.pageSize == 0L) {
            return 0L;
        } else {
            long pages = this.total / this.pageSize;
            if (this.total % this.pageSize != 0L) {
                ++pages;
            }
            return pages;
        }
    }
}
