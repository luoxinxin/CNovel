package io.github.xxyopen.novel.core.auth;

import io.github.xxyopen.novel.core.common.exception.BusinessException;
import io.github.xxyopen.novel.core.util.JwtUtils;
import io.github.xxyopen.novel.manager.cache.UserInfoCacheManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FrontAuthStrategy implements AuthStrategy{

    private final JwtUtils jwtUtils;

    private final UserInfoCacheManager userInfoCacheManager;
    @Override
    public void auth(String token, String requestUri) throws BusinessException {
        authSSO(jwtUtils, userInfoCacheManager, token);
    }
}
