package io.github.xxyopen.novel.dto.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfoRespDto {

    @Schema(description = "昵称")
    private String nickName;

    @Schema(description = "用户头像")
    private String userPhoto;

    @Schema(description = "用户性别")
    private Integer userSex;
}
