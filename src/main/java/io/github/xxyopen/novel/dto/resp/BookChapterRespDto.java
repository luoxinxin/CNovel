package io.github.xxyopen.novel.dto.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
public class BookChapterRespDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "章节ID")
    private Long id;

    @Schema(description = "小说ID")
    private Long bookId;

    @Schema(description = "章节号")
    private Integer chapterNum;

    @Schema(description = "章节名")
    private String chapterName;

    @Schema(description = "章节字数")
    private Integer chapterWordCount;

    @Schema(description = "章节更新时间")
    @JsonFormat(pattern = "yyyy/MM/dd HH:dd")
    private LocalDateTime chapterUpdateTime;

    @Schema(description = "是否收费;1-收费 0-免费")
    private Integer isVip;
}
