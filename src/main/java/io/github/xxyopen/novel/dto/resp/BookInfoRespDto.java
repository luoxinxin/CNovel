package io.github.xxyopen.novel.dto.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookInfoRespDto {

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

    @Schema(description = "作家id")
    private Long authorId;

    @Schema(description = "作家名")
    private String authorName;

    @Schema(description = "书籍描述")
    private String bookDesc;

    @Schema(description = "书籍状态;0-连载中 1-已完结")
    private Integer bookStatus;

    @Schema(description = "点击量")
    private Long visitCount;

    @Schema(description = "总字数")
    private Integer wordCount;

    @Schema(description = "评论数")
    private Integer commentCount;

    @Schema(description = "首章节ID")
    private Long firstChapterId;

    @Schema(description = "最新章节ID")
    private Long lastChapterId;

    @Schema(description = "最新章节名")
    private String lastChapterName;

    @Schema(description = "最新章节更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime updateTime;

}
