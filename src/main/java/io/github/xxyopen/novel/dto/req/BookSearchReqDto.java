package io.github.xxyopen.novel.dto.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.xxyopen.novel.core.common.req.PageReqDto;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class BookSearchReqDto extends PageReqDto {

    @Parameter(description = "搜索关键字")
    private String keyword;

    @Parameter(description = "作品方向")
    private Integer workDirection;

    @Parameter(description = "分类ID")
    private Integer categoryId;

    @Parameter(description = "是否收费，1：收费，0：免费")
    private Integer isVip;

    @Parameter(description = "小说更新状态，0：连载中，1：已完结")
    private Integer bookStatus;

    @Parameter(description = "字数最小值")
    private Integer wordCountMin;

    @Parameter(description = "字数最大值")
    private Integer wordCountMax;

    @Parameter(description = "最小更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTimeMin;

    @Parameter(description = "排序字段")
    private String sort;
}
