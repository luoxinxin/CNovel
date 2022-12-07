package io.github.xxyopen.novel.dto.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookContentAboutRespDto {

    @Schema(description = "小说信息")
    private BookInfoRespDto bookInfo;

    @Schema(description = "章节信息")
    private BookChapterRespDto chapterInfo;

    @Schema(description = "章节内容")
    private String bookContent;
}
