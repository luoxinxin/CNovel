package io.github.xxyopen.novel.dto.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class HomeBookRespDto {

    @Schema(description = "类型;0-轮播图 1-顶部栏 2-本周强推 3-热门推荐 4-精品推荐")
    private Integer type;

    @Schema(description = "小说ID")
    private Long bookId;

    @Schema(description = "小说封面地址")
    private String picUrl;

    @Schema(description = "小说名")
    private String bookName;

    @Schema(description = "作家名")
    private String authorName;

    @Schema(description = "书籍描述")
    private String bookDesc;
}
