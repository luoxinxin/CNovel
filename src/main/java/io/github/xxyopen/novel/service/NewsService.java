package io.github.xxyopen.novel.service;

import io.github.xxyopen.novel.core.common.resp.RestResp;
import io.github.xxyopen.novel.dto.resp.NewsInfoRespDto;

import java.util.List;

public interface NewsService {

    RestResp<List<NewsInfoRespDto>> listLatestNews();

    RestResp<NewsInfoRespDto> getNews(Long id);

}
