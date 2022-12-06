package io.github.xxyopen.novel.core.auth;

import io.github.xxyopen.novel.core.common.constant.ErrorCodeEnum;
import io.github.xxyopen.novel.core.common.exception.BusinessException;
import io.github.xxyopen.novel.core.constant.SystemConfigConsts;
import io.github.xxyopen.novel.core.util.JwtUtils;
import io.github.xxyopen.novel.dto.UserInfoDto;
import io.github.xxyopen.novel.manager.cache.UserInfoCacheManager;
import org.springframework.util.StringUtils;

import java.util.Objects;

public interface AuthStrategy {

    void auth(String token, String requestUri) throws BusinessException;

    default Long authSSO(JwtUtils jwtUtils, UserInfoCacheManager userInfoCacheManager, String token) {
        if (!StringUtils.hasText(token)) {
            throw new BusinessException(ErrorCodeEnum.USER_LOGIN_EXPIRED);
        }

        Long userId = jwtUtils.parseToken(token, SystemConfigConsts.NOVEL_FRONT_KEY);

        if (Objects.isNull(userId)) {
            throw new BusinessException(ErrorCodeEnum.USER_LOGIN_EXPIRED);
        }

        UserInfoDto userInfo = userInfoCacheManager.getUser(userId);

        if (Objects.isNull(userId)) {
            throw new BusinessException(ErrorCodeEnum.SYSTEM_ERROR);
        }

        UserHolder.setUserId(userId);

        return userId;

    }
}
