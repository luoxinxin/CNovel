package io.github.xxyopen.novel.dto.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class HomeFriendLinkRespDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "链接名")
    private String linkName;

    @Schema(description = "链接url")
    private String linkUrl;
}
