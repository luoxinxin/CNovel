package io.github.xxyopen.novel.service;

import io.github.xxyopen.novel.core.common.resp.RestResp;
import io.github.xxyopen.novel.dto.req.UserInfoUptReqDto;
import io.github.xxyopen.novel.dto.req.UserLoginReqDto;
import io.github.xxyopen.novel.dto.req.UserRegisterReqDto;
import io.github.xxyopen.novel.dto.resp.UserInfoRespDto;
import io.github.xxyopen.novel.dto.resp.UserLoginRespDto;
import io.github.xxyopen.novel.dto.resp.UserRegisterRespDto;

public interface UserService {

    RestResp<UserRegisterRespDto> register(UserRegisterReqDto dto);

    RestResp<UserLoginRespDto> login(UserLoginReqDto dto);

    RestResp<UserInfoRespDto> getUserInfo(Long userId);

    RestResp<Void> updateUserInfo(UserInfoUptReqDto dto);

    RestResp<Void> saveFeedback(Long userId, String content);

    RestResp<Void> deleteFeedback(Long userId, Long id);

    RestResp<Integer> getBookshelfStatus(Long userId, String bookId);

}
