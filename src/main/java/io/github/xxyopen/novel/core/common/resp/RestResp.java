package io.github.xxyopen.novel.core.common.resp;

import io.github.xxyopen.novel.core.common.constant.ErrorCodeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.util.Objects;

@Getter
public class RestResp<T> {

    @Schema(description = "错误码，0000-没有错误")
    private String code;

    @Schema(description = "响应信息")
    private String message;

    @Schema(description = "响应数据")
    private T data;

    private RestResp() {
        this.code = ErrorCodeEnum.OK.getCode();
        this.message = ErrorCodeEnum.OK.getMessage();
    }

    private RestResp(ErrorCodeEnum errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    private RestResp(T data) {
        this();
        this.data = data;
    }

    public static RestResp<Void> ok() {
        return new RestResp<>();
    }

    public static <T> RestResp<T> ok(T data) {
        return new RestResp<>(data);
    }

    public static RestResp<Void> fail(ErrorCodeEnum errorCode) {
        return new RestResp<>(errorCode);
    }

    public static RestResp<Void> error() {
        return new RestResp<>(ErrorCodeEnum.SYSTEM_ERROR);
    }

    public boolean isOk() {
        return Objects.equals(this.code, ErrorCodeEnum.OK.getCode());
    }




}
