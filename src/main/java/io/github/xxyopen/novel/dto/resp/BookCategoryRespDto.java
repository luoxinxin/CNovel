package io.github.xxyopen.novel.dto.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookCategoryRespDto {

    @Schema(description = "类别ID")
    private Long id;

    @Schema(description = "类别名")
    private String name;
}
