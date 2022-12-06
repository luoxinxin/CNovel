package io.github.xxyopen.novel.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ChapterAddReqDto {

    @Schema(description = "小说ID", required = true)
    private Long bookId;

    @Schema(description = "章节名", required = true)
    @NotBlank
    private String ChapterName;

    @Schema(description = "章节内容", required = true)
    @NotBlank
    private String chapterContent;

    @Schema(description = "是否收费;1-收费 0-免费", required = true)
    @NotNull
    private Integer isVip;
}
