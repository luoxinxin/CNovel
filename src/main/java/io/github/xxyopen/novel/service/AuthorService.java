package io.github.xxyopen.novel.service;

import io.github.xxyopen.novel.core.common.resp.RestResp;
import io.github.xxyopen.novel.dto.req.AuthorRegisterReqDto;

/**
 * <p>
 * 作者信息 服务类
 * </p>
 *
 * @author lxx
 * @since 2022/11/25
 */
public interface AuthorService {

    RestResp<Void> register(AuthorRegisterReqDto dto);

    RestResp<Integer> getStatus(Long userId);

}
