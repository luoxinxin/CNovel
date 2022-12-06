package io.github.xxyopen.novel.core.common.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ImgVerifyCodeRespDto {

    @Schema(description = "sessionId")
    private String sessionId;

    @Schema(description = "Base64 编码的验证码图片")
    private String img;
}
