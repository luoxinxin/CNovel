package io.github.xxyopen.novel.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;

@Data
@Builder
public class UserInfoDto {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer status;
}
