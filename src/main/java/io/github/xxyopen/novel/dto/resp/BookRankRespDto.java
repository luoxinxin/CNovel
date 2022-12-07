package io.github.xxyopen.novel.dto.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BookRankRespDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "小说ID")
    private Long id;

    @Schema(description = "类别ID")
    private Long categoryId;

    @Schema(description = "类别名")
    private String categoryName;

    @Schema(description = "小说封面地址")
    private String picUrl;

    @Schema(description = "小说名")
    private String bookName;

    @Schema(description = "作家名")
    private String authorName;

    @Schema(description = "书籍描述")
    private String bookDesc;

    @Schema(description = "总字数")
    private Integer wordCount;

    @Schema(description = "最新章节名")
    private String lastChapterName;

    @Schema(description = "最新章节更新时间")
    @JsonFormat(pattern = "MM/dd HH:mm")
    private LocalDateTime lastChapterUpdateTime;
}
