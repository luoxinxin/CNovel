package io.github.xxyopen.novel.service;

import io.github.xxyopen.novel.core.common.resp.RestResp;
import io.github.xxyopen.novel.dto.resp.HomeBookRespDto;
import io.github.xxyopen.novel.dto.resp.HomeFriendLinkRespDto;

import java.util.List;

public interface HomeService {

    RestResp<List<HomeBookRespDto>> listHomeBooks();

    RestResp<List<HomeFriendLinkRespDto>> listHomeFriendLinks();
}
