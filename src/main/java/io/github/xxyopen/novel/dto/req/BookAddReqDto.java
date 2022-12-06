package io.github.xxyopen.novel.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookAddReqDto {

    @Schema(description = "作品方向;0-男频 1-女频", required = true)
    @NotNull
    private Integer workDirection;

    @Schema(description = "类别ID", required = true)
    @NotNull
    private Long categoryId;

    @Schema(description = "类别名", required = true)
    @NotBlank
    private String categoryName;

    @Schema(description = "小说封面地址", required = true)
    @NotBlank
    private String picUrl;

    @Schema(description = "小说名", required = true)
    @NotBlank
    private String bookName;

    @Schema(description = "书籍描述", required = true)
    @NotBlank
    private String bookDesc;

    @Schema(description = "是否收费;1-收费 0-免费", required = true)
    @NotBlank
    private Integer isVip;
}
