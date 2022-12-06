package io.github.xxyopen.novel.core.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {

    OK("00000", "一切 ok"),

    USER_ERROR("A0001", "用户端错误"),
    SYSTEM_ERROR("B0001", "系统执行出错"),

    USER_LOGIN_EXPIRED("A0230", "用户登录已过期"),

    AUTHOR_BOOK_NAME_EXIST("A3001", "小说名已存在"),

    USER_UN_AUTH("A0301", "访问未授权"),

    USER_UPLOAD_FILE_ERROR("A0700", "用户上传文件异常"),

    USER_UPLOAD_FILE_TYPE_NOT_MATCH("A0701", "用户上传文件类型不匹配"),

    USER_VERIFY_CODE_ERROR("A0240", "用户验证码错误"),

    USER_NAME_EXIST("A0111", "用户名已存在"),

    USER_ACCOUNT_NOT_EXIST("A0201", "用户账号不存在"),

    USER_PASSWORD_ERROR("A0210", "用户密码错误"),

    USER_COMMENTED("A2001", "用户已发表评论");

    private final String code;

    private final String message;

}
