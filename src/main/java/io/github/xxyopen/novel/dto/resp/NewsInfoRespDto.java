package io.github.xxyopen.novel.dto.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NewsInfoRespDto {

    @Schema(description = "新闻ID")
    private Long id;

    @Schema(description = "类别ID")
    private Long categoryId;

    @Schema(description = "类别名")
    private String categoryName;

    @Schema(description = "新闻来源")
    private String sourceName;

    @Schema(description = "新闻标题")
    private String title;

    @Schema(description = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime updateTime;

    @Schema(description = "新闻内容")
    private String content;
}
